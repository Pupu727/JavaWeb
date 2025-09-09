package com.lirui.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lirui.Mapper.EmpLogMapper;
import com.lirui.Pojo.EmpLog;
import com.lirui.Pojo.PageResult;
import com.lirui.Service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;
    
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }

    @Override
    public PageResult<EmpLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<EmpLog> p = (Page<EmpLog>) empLogMapper.list();
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
