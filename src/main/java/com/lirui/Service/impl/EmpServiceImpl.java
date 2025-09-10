package com.lirui.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lirui.Mapper.EmpExprMapper;
import com.lirui.Mapper.EmpLogMapper;
import com.lirui.Mapper.EmpMapper;
import com.lirui.Pojo.*;
import com.lirui.Service.EmpService;
import com.lirui.ultis.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogMapper empLogMapper;
    @Override
    public PageResult<Emp> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        Page<Emp> p = (Page<Emp>) empMapper.list(empQueryParam);
//        Long total = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Emp emp) {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            if (!CollectionUtils.isEmpty(emp.getExprList())) {
                emp.getExprList().forEach(e -> e.setEmpId(emp.getId()));
                empExprMapper.insertBatch(emp.getExprList());
            }
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional
    @Override
    public void update(Emp emp) {
        Long startTime = System.currentTimeMillis();
        try {
            emp.setUpdateTime(LocalDateTime.now());
            //1.更新员工信息
            empMapper.update(emp);
            if (!CollectionUtils.isEmpty(emp.getExprList())) {
                //2.删除员工经历(非空)
                empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
                //3.新增员工经历
                emp.getExprList().forEach(e -> e.setEmpId(emp.getId()));
                empExprMapper.insertBatch(emp.getExprList());
            }
        } finally {
            Long endTime = System.currentTimeMillis();
            EmpLog emplog = new EmpLog(null, emp.getId(), LocalDateTime.now(),emp.getClass().toString(),
                    "update",emp.toString(),Result.success().toString(),endTime-startTime,emp.getName());
            empLogMapper.insert(emplog);
        }
    }

    @Override
    public List<Emp> listMaster() {
        return empMapper.listMaster();
    }

    @Override
    public LoginInfo login(Emp emp) {
        LoginInfo l = empMapper.findUser(emp);
        if(l != null){
            Map<String,Object> map = new HashMap<>();
            map.put("id",l.getId());
            map.put("username",l.getUsername());
            return new LoginInfo(l.getId(),l.getUsername(),l.getName(), JwtUtils.createToken(map));
        }
        return null;
    }
}