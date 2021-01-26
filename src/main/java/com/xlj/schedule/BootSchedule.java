package com.xlj.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * springboot 定时任务调度
 *
 * @author xlj
 * @date 2021/1/26
 */
@Slf4j
@Component
@EnableAsync
@EnableScheduling
public class BootSchedule {

    @Async
    @Scheduled(cron = "* * * * * ?")
    public void hello() throws InterruptedException {
        Thread.sleep(3000);
        log.info("hello");
    }
}
