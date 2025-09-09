package com.lirui.Service;


import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import com.lirui.Pojo.LoginInfo;
import com.lirui.Pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult<Emp> list(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    List<Emp> listMaster();

    LoginInfo login(Emp emp);
}
