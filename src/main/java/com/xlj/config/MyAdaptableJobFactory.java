package com.xlj.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 处理Job类中注入service对象，未注入将产生异常
 * @Author XLJ
 * @Date 2020/8/25
 */
@Component
public class MyAdaptableJobFactory extends AdaptableJobFactory {
    // 可以将一个对象添加到IOC容器中，并完成注入
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    /**
     * @description: 将实例化的任务对象手动添加到IOC并完成注入
     * @author XLJ
     * @date 2020/8/25 14:46
    */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
