package com.example.demo.myScheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @ClassName OperaController
 * @Description
 * @Author huangrq
 * @Date 2019/2/13 11:41
 */
@RestController
public class OperaController {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future1;

    private ScheduledFuture<?> future2;

    String corn1 = "0 0/1 6-23 * * ?";
    String corn2 = "0 0/3 6-23 * * ?";

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @PostMapping("/startCron1")
    public String startCron1() {

        future1 = threadPoolTaskScheduler.schedule(new MyRunnable1(),new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                return new CronTrigger(corn1).nextExecutionTime(triggerContext);
            }
        });

        System.out.println("DynamicTask.startCron1()");

        return "ok";

    }

    @PostMapping("/stopCron1")
    public String stopCron1() {
        if (future1 != null) {
            future1.cancel(true);
        }
        System.out.println("DynamicTask.stopCron1()");
        return "ok";
    }


    @PostMapping("/startCron2")
    public String startCron2() {

        future2 = threadPoolTaskScheduler.schedule(new MyRunnable2(),new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                return new CronTrigger(corn2).nextExecutionTime(triggerContext);
            }
        });

        System.out.println("DynamicTask.startCron2()");

        return "ok";

    }

    @PostMapping("/stopCron2")
    public String stopCron2() {
        if (future2 != null) {
            future2.cancel(true);
        }
        System.out.println("DynamicTask.stopCron2()");

        return "ok";
    }



}



