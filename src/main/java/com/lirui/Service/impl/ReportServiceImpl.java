package com.lirui.Service.impl;

import com.lirui.Mapper.EmpMapper;
import com.lirui.Pojo.JobOption;
import com.lirui.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public JobOption getJobOptions() {
        List<Map<String,Object>> jobOptions = empMapper.getJobOptions();
        List<Object> jobList = jobOptions.stream().map(dataMap -> dataMap.get("ops")).toList();
        List<Object> dataList = jobOptions.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getGenderData() {
        return empMapper.getGenderData();
    }
}
