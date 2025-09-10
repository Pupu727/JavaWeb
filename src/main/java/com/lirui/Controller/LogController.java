package com.lirui.Controller;

import com.lirui.Pojo.OperateLog;
import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Result;
import com.lirui.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/page")
    public Result list(Integer page, Integer pageSize){
        PageResult<OperateLog> pr = logService.list(page, pageSize);
        return Result.success(pr);
    }
}
