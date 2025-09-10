package com.lirui.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lirui.Mapper.LogMapper;
import com.lirui.Pojo.OperateLog;
import com.lirui.Pojo.PageResult;
import com.lirui.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<OperateLog> list(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<OperateLog> pr = (Page<OperateLog>) logMapper.list();
        return new PageResult<>(pr.getTotal(), pr.getResult());
    }
}
