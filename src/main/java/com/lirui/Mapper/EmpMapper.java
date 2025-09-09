package com.lirui.Mapper;

import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp (username,password,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) " +
            "values (#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    @MapKey("ops")
    List<Map<String,Object>> getJobOptions();

    @MapKey("name")
    List<Map<String, Object>> getGenderData();

    @Select("select e.id,e.name from emp e where e.job = 1")
    List<Emp> listMaster();
}
