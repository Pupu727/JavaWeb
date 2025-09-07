package com.lirui.Service;

import com.lirui.Pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();
    void delete(Integer id);

    void save(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
