package com.example.demo.valid;

/**
 * @ClassName PxxMustNumber
 * @Description // 必须为数字
 * @Author huangrq
 * @Date 2019/1/16 19:05
 */
public @interface PxxMustNumber {
    /**
     * 必须为数字
     * @return
     */
    public boolean isNum() default false;
    public String exceptionMsg () default "必须为数字";
}
