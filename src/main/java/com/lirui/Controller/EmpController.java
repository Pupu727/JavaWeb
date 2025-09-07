package com.lirui.Controller;

import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Result;
import com.lirui.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
}
