package com.lirui.Mapper;

import com.lirui.Pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    @Select("SELECT l.id,operate_emp_id,operate_time,cost_time,method_params,return_value,method_name,class_name," +
            "e.name operateEmpName FROM operate_log l " +
            "LEFT JOIN emp e ON l.operate_emp_id = e.id")
    public List<OperateLog> list();
}
