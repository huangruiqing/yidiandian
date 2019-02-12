package com.baiwang.cloud.output.api.provider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author liujp
 * @date 2018/10/11
 */
@Configuration
public class ExecutorConfiguration
{
    @Value("${async.executor.thread.core_pool_size:100}")
    private int corePoolSize;
    @Value("${async.executor.thread.max_pool_size:200}")
    private int maxPoolSize;
    @Value("${async.executor.thread.queue_capacity:500}")
    private int queueCapacity;
    private String threadNamePrefix = "output-api-ExecutorThread-";

    @Bean
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}