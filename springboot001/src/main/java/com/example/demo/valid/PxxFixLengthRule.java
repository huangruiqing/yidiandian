package com.example.demo.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName PxxFixLengthRule
 * @Description // 固定长度
 * @Author huangrq
 * @Date 2019/1/16 19:04
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PxxFixLengthRule {
    /**
     * 固定长度
     *
     * @return
     */
    public int fixLength();

    /**
     * 异常信息描述
     *
     * @return
     */
    public String exceptionMsg() default "";
}
