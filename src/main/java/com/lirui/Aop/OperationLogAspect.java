package com.lirui.Aop;

import com.lirui.Mapper.OperateLogMapper;
import com.lirui.Pojo.OperateLog;
import com.lirui.ultis.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class OperationLogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.lirui.Aop.anno.LogOperation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        OperateLog operateLog = new OperateLog();
        operateLog.setCostTime(time);
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setOperateEmpId(getCurrentUserId());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName()); //操作类名
        operateLog.setMethodName(joinPoint.getSignature().getName()); //操作方法名
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs())); //操作方法参数
        operateLog.setReturnValue(proceed.toString()); //操作方法返回值
        operateLogMapper.insert(operateLog);
        return proceed;
    }

    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
