package com.lirui.Service;


import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import com.lirui.Pojo.PageResult;

public interface EmpService {

    PageResult<Emp> list(EmpQueryParam empQueryParam);

    void save(Emp emp);
}
