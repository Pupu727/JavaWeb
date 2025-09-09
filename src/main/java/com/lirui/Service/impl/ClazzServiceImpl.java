package com.lirui.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lirui.Exception.ClazzHasStudentsException;
import com.lirui.Mapper.ClazzMapper;
import com.lirui.Pojo.Clazz;
import com.lirui.Pojo.ClazzQueryParam;
import com.lirui.Pojo.PageResult;
import com.lirui.Service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        Page<Clazz> clazzList = (Page<Clazz>) clazzMapper.list(clazzQueryParam);
        log.info("查询班级列表，参数：{}，结果：{}",clazzQueryParam,clazzList);
        return new PageResult<>(clazzList.getTotal(), clazzList.getResult());
    }

    @Override
    public void delete(Integer id) {
        int count = clazzMapper.findStuByClazzId(id);
        if(count > 0 ){
            log.warn("班级ID为{}的班级下有{}名学生，不允许删除", id,count);
            throw new ClazzHasStudentsException("对不起, 该班级下有学生, 不能直接删除");
        }else{
            clazzMapper.delete(id);
        }
    }

    @Override
    public void insert(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setCreateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz findById(Integer id) {
        log.info("根据id查询班级信息，参数：{}，结果：{}",id,clazzMapper.findById(id));
        return clazzMapper.findById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.listAll();
    }
}
