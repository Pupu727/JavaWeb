package com.lirui.Controller;

import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Result;
import com.lirui.Pojo.Student;
import com.lirui.Pojo.StudentQueryParam;
import com.lirui.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result list(StudentQueryParam studentQueryParam){
        log.info("查询学生列表,参数:{}",studentQueryParam);
        PageResult<Student> pageResult = studentService.findAll(studentQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除学生,参数:{}",ids);
        studentService.delete(ids);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("新增学生,参数:{}",student);
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询学生,参数:{}",id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学生,参数:{}",student);
        studentService.update(student);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id,@PathVariable Short score){
        log.info("修改学生违纪扣分,参数:{}",id);
        studentService.updateViolation(id,score);
        return Result.success();
    }
}
