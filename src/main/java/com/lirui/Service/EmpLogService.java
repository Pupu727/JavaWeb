package com.lirui.Service;

import com.lirui.Pojo.EmpLog;
import com.lirui.Pojo.PageResult;

public interface EmpLogService {

    public void insertLog(EmpLog empLog);

    public PageResult<EmpLog> page(Integer page, Integer pageSize);
}
