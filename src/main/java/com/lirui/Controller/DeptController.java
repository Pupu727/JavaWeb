package com.lirui.Controller;

import com.lirui.Pojo.Dept;
import com.lirui.Pojo.Result;
import com.lirui.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result findAll(){
        log.info("查询所有部门");
        return Result.success(deptService.findAll());
    }
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id){
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Dept dept){
        log.info("新增部门");
        deptService.save(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询部门"+id);
        return Result.success(deptService.findById(id));
    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("根据id修改部门");
        deptService.update(dept);
        return Result.success();
    }
}
