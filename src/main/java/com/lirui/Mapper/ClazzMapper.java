package com.lirui.Mapper;

import com.lirui.Pojo.Clazz;
import com.lirui.Pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(@Param("clazzQueryParam") ClazzQueryParam clazzQueryParam);

    void delete(Integer id);

    void insert(Clazz clazz);

    @Select("select * from clazz where id = #{id}")
    Clazz findById(Integer id);

    void update(Clazz clazz);

    int findStuByClazzId(Integer id);

    @Select("select c.id,c.name from clazz c")
    List<Clazz> listAll();
}
