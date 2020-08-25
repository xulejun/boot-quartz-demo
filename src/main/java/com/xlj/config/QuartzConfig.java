package com.xlj.config;

import com.xlj.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Quartz配置类
 *
 * @Author XLJ
 * @Date 2020/8/25
 */
@Configuration
public class QuartzConfig {
    /**
     * @description: 创建Job对象（做什么工作）
     * @author XLJ
     * @date 2020/8/25 14:02
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        // 关联自定义的Job类
        jobDetailFactoryBean.setJobClass(QuartzDemo.class);
        return jobDetailFactoryBean;
    }

    /**
     * @description: 创建简单的Trigger对象（什么时候工作）
     * @author XLJ
     * @date 2020/8/25 14:04
     */
//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
//        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//        // 关联JobDetail对象
//        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
//        // 执行的毫秒数——2s执行一次
//        simpleTriggerFactoryBean.setRepeatInterval(2000);
//        // 重复次数
//        simpleTriggerFactoryBean.setRepeatCount(5);
//        return simpleTriggerFactoryBean;
//    }

    /**
     * @description: 创建Cron Trigger对象
     * @author XLJ
     * @date 2020/8/25 14:25
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        // 设置触发时间
        cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
        return cronTriggerFactoryBean;
    }

    /**
     * @description: 创建Schedule对象（搭配工作和触发器）
     * @author XLJ
     * @date 2020/8/25 14:13
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 关联Trigger对象
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        // 关联service
        schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
        return schedulerFactoryBean;
    }

}
