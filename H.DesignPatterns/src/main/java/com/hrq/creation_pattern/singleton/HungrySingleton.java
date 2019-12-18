package com.hrq.creation_pattern.singleton;

/**
 * @ClassName HungrySingleton
 * @Description 饿汉式 上来就建造（static在初始化）
 * @Author huangrq
 * @Date 2019/12/16 20:16
 */
public class HungrySingleton {

    private static final  HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){};

    public static  HungrySingleton getInstance() {
        return instance;
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
