package com.hrq.creation_pattern.singleton;

/**
 * @ClassName SingletonTest
 * @Description
 * @Author huangrq
 * @Date 2019/12/17 13:52
 */
public class SingletonTest {

    public static void main(String[] args) {

        //1、
        HungrySingleton hungrySingleton_1 =  HungrySingleton.getInstance();
        HungrySingleton hungrySingleton_2 =  HungrySingleton.getInstance();
        System.out.println(hungrySingleton_1==hungrySingleton_2);
        hungrySingleton_1.setName("饿汉式");
        System.out.println(hungrySingleton_2.getName());

        SingletonEnum.MyResource myResource = SingletonEnum.INSTANCE.getMyResourceInstance();
        myResource.setSourceName("enum 式");

        System.out.println(SingletonEnum.INSTANCE.getMyResourceInstance().getSourceName());

        SingletonEnum singletonEnum =  SingletonEnum.INSTANCE;
        singletonEnum.setName("枚举");
        System.out.println(SingletonEnum.INSTANCE.getName());


    }


}
