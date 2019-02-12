package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName AsyncConfig
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/2/11 11:00
 */
@Configuration
@EnableAsync
public class AsyncConfig {
    /*
   此处成员变量应该使用@Value从配置中读取
    */
    private int corePoolSize = 10;
    private int maxPoolSize = 200;
    private int queueCapacity = 10;
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
