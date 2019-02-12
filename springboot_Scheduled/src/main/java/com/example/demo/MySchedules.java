package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MySchedules
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/2/11 11:17
 */
@Component
public class MySchedules {

    private static final Logger logger = LoggerFactory.getLogger(MySchedules.class);

    @Autowired
    protected ThreadPoolTaskExecutor executor;

    @Scheduled(cron="0 0/1 * * * ?")
    public void executeFileDownLoadTask1() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
    //    System.out.println("定时任务1:"+current.getId());
        executor.execute(new MyTask());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }

    @Scheduled(cron="0 0/1 * * * ?")
    public void executeFileDownLoadTask2() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
       // System.out.println("定时任务1:"+current.getId());
        executor.execute(new MyTask());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务2:"+current.getId()+ ",name:"+current.getName());
    }

    @Scheduled(cron="0 0/1 * * * ?")
    public void executeFileDownLoadTask3() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
   //     System.out.println("定时任务1:"+current.getId());
        executor.execute(new MyTask());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务3:"+current.getId()+ ",name:"+current.getName());
    }

}
