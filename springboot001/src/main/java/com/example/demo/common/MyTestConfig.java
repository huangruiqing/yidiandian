package com.example.demo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyTestConfig
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/25 16:22
 */
@Component
public class MyTestConfig {
    @Value("${test.config.1}")
    private  String testConfig;

    public String getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(String testConfig) {
        this.testConfig = testConfig;
    }
}
