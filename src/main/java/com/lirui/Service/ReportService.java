package com.lirui.Service;

import com.lirui.Pojo.ClazzStuCount;
import com.lirui.Pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getJobOptions();

    List<Map<String, Object>> getGenderData();

    List<Map<String, Object>> getStudentDegreeData();

    ClazzStuCount getStudentCountData();
}
