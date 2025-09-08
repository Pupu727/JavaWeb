package com.lirui.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lirui.Mapper.EmpExprMapper;
import com.lirui.Mapper.EmpLogMapper;
import com.lirui.Mapper.EmpMapper;
import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpLog;
import com.lirui.Pojo.EmpQueryParam;
import com.lirui.Pojo.PageResult;
import com.lirui.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            if (!CollectionUtils.isEmpty(emp.getExprList())) {
                emp.getExprList().forEach(e -> e.setEmpId(emp.getId()));
                empExprMapper.insertBatch(emp.getExprList());
            }
        } finally {
            EmpLog emplog = new EmpLog(null, LocalDateTime.now(), "新增员工"+emp);
            empLogMapper.insert(emplog);
        }
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }
}