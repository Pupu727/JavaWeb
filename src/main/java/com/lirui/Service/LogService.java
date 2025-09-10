package com.lirui.Service;

import com.lirui.Pojo.OperateLog;
import com.lirui.Pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> list(Integer page, Integer pageSize);
}
