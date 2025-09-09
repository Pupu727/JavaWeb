package com.lirui.Controller;

import com.lirui.Pojo.Clazz;
import com.lirui.Pojo.ClazzQueryParam;
import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Result;
import com.lirui.Service.ClazzService;
import com.lirui.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result findAll(ClazzQueryParam clazzQueryParam){
        log.info("查询班级列表，参数：{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.findAll(clazzQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        clazzService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Clazz clazz){
        clazzService.insert(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return Result.success();
    }
    @GetMapping("/list")
    public Result list(){
        List<Clazz> list = clazzService.list();
        return Result.success(list);
    }
}
