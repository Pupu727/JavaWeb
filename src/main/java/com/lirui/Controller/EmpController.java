package com.lirui.Controller;

import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Result;
import com.lirui.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result list(EmpQueryParam empQueryParam) {
        log.info("分页查询，参数：{}",empQueryParam);
        PageResult<Emp> pr = empService.list(empQueryParam);
        return Result.success(pr);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }
}
