package com.lirui.Controller;

import com.lirui.Aop.anno.LogOperation;
import com.lirui.Mapper.EmpExprMapper;
import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Result;
import com.lirui.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpExprMapper empExprMapper;

    @GetMapping
    public Result list(EmpQueryParam empQueryParam) {
        log.info("分页查询，参数：{}",empQueryParam);
        PageResult<Emp> pr = empService.list(empQueryParam);
        return Result.success(pr);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @LogOperation
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @LogOperation
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工：{}",ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工：{}",emp);
        empService.update(emp);
        return Result.success();
    }
    @GetMapping("/list")
    public Result findAll() {
        List<Emp> list = empService.listMaster();
        return Result.success(list);
    }
}
