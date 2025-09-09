package com.lirui.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lirui.Mapper.StudentMapper;
import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Student;
import com.lirui.Pojo.StudentQueryParam;
import com.lirui.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> findAll(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        Page<Student> page = (Page<Student>) studentMapper.list(studentQueryParam);
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void save(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        studentMapper.insert(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void updateViolation(Integer id, Short score) {
        Student s = studentMapper.findById(id);
        s.setViolationScore( (short) (s.getViolationScore()+score));
        s.setViolationCount((short) (s.getViolationCount()+1));
        studentMapper.update(s);
    }
}
