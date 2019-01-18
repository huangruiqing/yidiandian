package com.example.demo.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName PxxRequiredRule
 * @Description // 必填项
 * @Author huangrq
 * @Date 2019/1/16 19:05
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PxxRequiredRule {
    /**
     * 必填项
     * true 为必填项
     * @return
     */
    public boolean required() default false;
    /**
     * 具体异常信息
     * @return
     */
    public String exceptionMsg() default "异常信息";

}
