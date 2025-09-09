package com.lirui.Mapper;

import com.lirui.Pojo.Student;
import com.lirui.Pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public List<Student> list(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void insert(Student student);

    @Select("select * from student where id = #{id}")
    Student findById(Integer id);

    void update(Student student);

    @MapKey("degree")
    List<Map<String, Object>> getStudentDegreeData();

    @MapKey("clazzName")
    List<Map<String, Object>> getStudentCountData();
}
