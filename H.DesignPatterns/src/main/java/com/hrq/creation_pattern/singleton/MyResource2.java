package com.hrq.creation_pattern.singleton;

/**
 * @ClassName MyResource2
 * @Description
 * @Author huangrq
 * @Date 2019/12/17 11:13
 */
public class MyResource2 {

    private String sourceName;

    private MyResource2(){}

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
