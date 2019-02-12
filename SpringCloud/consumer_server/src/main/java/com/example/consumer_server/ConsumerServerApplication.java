package com.example.consumer_server;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerApplication.class, args);
    }

    @Bean
    @LoadBalanced
//默认轮询
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * <p>RoundRobinRule:轮询
     * <p>RandomRule:随机
     * <p>AvailabilityFilteringRule: 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,以及并发的连接数量
     * <p>超过阈值的服务,然后对剩余的服务列表按照轮询策略进行访问;
     * <p>WeightedResponseTimeRule: 根据平均响应时间计算所有服务的权重,响应时间越快,服务权重越大,被选中的机率越高;
     * <p>刚启动时,如果统计信息不足,则使用RoundRobinRule策略,等统计信息足够时,会切换到WeightedResponseTimeRule
     * <p>RetryRule: 先按照RoundRobinRule的策略获取服务,如果获取服务失败,则在指定时间内会进行重试,获取可用的服务;
     * <p>BestAvailableRule: 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量最小的服务;
     * <p>ZoneAvoidanceRule: 默认规则,复合判断server所在区域的性能和server的可用性选择服务器
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        //	return new RoundRobinRule(); // 显式的指定使用轮询算法
        return new RandomRule(); // 显式的指定使用随机
    }
}

