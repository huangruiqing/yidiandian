package com.example.demo.H2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName DemoInfo
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/18 19:15
 */
@Entity
public class DemoInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String context;

    public DemoInfo() {
    }

    public DemoInfo(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
