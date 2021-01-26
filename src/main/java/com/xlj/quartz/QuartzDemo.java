package com.xlj.quartz;

import com.xlj.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Job任务类
 * @Author XLJ
 * @Date 2020/8/25
 */
public class QuartzDemo implements Job {
    @Autowired
    private UserService userService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("Quartz调用，当前时间："+ LocalDateTime.now());
//        userService.addUser();
    }
}
