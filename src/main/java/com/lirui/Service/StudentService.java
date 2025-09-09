package com.lirui.Service;

import com.lirui.Pojo.PageResult;
import com.lirui.Pojo.Student;
import com.lirui.Pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> findAll(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void save(Student student);

    Student findById(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Short score);
}
