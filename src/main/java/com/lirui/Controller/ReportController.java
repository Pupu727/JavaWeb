package com.lirui.Controller;

import com.lirui.Pojo.JobOption;
import com.lirui.Pojo.Result;
import com.lirui.Service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/empJobData")
    public Result  getEmpJobData(){
        log.info("统计员工岗位信息");
        JobOption jobData = reportService.getJobOptions();
        return Result.success(jobData);
    }
    @GetMapping("/empGenderData")
    public Result  getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map<String,Object>> list = reportService.getGenderData();
        return Result.success(list);
    }
}
