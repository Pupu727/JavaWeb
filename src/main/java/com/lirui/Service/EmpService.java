package com.lirui.Service;


import com.lirui.Pojo.Emp;
import com.lirui.Pojo.EmpQueryParam;
import com.lirui.Pojo.PageResult;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EmpService {

    PageResult<Emp> list(EmpQueryParam empQueryParam);
}
