package com.lirui.Service.impl;

import com.lirui.Mapper.EmpLogMapper;
import com.lirui.Pojo.EmpLog;
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
}
