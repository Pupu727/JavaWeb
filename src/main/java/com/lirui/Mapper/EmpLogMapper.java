package com.lirui.Mapper;

import com.lirui.Pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Mapper
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface EmpLogMapper {

    @Insert("insert into emp_log (id,operate_emp_id,operate_time, class_name, method_name, method_params, return_value, cost_time, operate_emp_name) " +
            "values (#{id}, #{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime}, #{operateEmpName})")
    public void insert(EmpLog empLog);

    List<EmpLog> list();

}
