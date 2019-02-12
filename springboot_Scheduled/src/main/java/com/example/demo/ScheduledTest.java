package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScheduledTest
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/2/11 10:40
 */
//@Component
public class ScheduledTest {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);


    @Scheduled(cron="0 0/1 * * * ?")
    public void executeFileDownLoadTask() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务1:"+current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    //    System.out.println("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }
    @Async
    @Scheduled(cron="0 0/1 * * * ?")
    public void executeUploadTask() {

        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId());
        logger.info("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());
      //  System.out.println("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());
    }
    @Async
    @Scheduled(cron="0 0/1 * * * ?")
    public void executeUploadBackTask() {

        // 间隔3分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务3:"+current.getId());
        logger.info("ScheduledTest.executeUploadBackTask 定时任务3:"+current.getId()+ ",name:"+current.getName());
       // System.out.println("ScheduledTest.executeUploadBackTask 定时任务3:"+current.getId()+ ",name:"+current.getName());
    }



}
