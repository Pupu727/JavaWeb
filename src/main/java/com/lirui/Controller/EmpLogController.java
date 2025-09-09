package com.lirui.Controller;

import com.lirui.Pojo.EmpLog;
import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Result;
import com.lirui.Service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class EmpLogController {
    @Autowired
    private EmpLogService empLogService;
    @GetMapping("/page")
    public Result page(Integer page, Integer pageSize){
        PageResult<EmpLog> pageResult = empLogService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
