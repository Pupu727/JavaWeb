package com.lirui.Mapper;

import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time limit #{page},#{pageSize}")

    //@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
    //       "order by e.update_time")
    public List<Emp> list(EmpQueryParam empQueryParam);
}
