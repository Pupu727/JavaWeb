package com.lirui.Service;

import com.lirui.Pojo.Clazz;
import com.lirui.Pojo.ClazzQueryParam;
import com.lirui.Pojo.PageResult;

public interface ClazzService {
    PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    void delete(Integer id);

    void insert(Clazz clazz);

    Clazz findById(Integer id);

    void update(Clazz clazz);
}
