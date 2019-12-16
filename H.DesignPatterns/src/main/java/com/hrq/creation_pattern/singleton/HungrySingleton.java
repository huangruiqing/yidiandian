package com.hrq.creation_pattern.singleton;

/**
 * @ClassName HungrySingleton
 * @Description 饿汉式 上来就建造（在初始化）
 * @Author huangrq
 * @Date 2019/12/16 20:16
 */
public class HungrySingleton {

    private static volatile HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){};

    public static  HungrySingleton getInstance() {
        return instance;
    }

}
