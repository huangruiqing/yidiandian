package com.hrq.creation_pattern.builder;

/**
 * @ClassName BuilderTest
 * @Description 创建者模式
 * @Author huangrq
 * @Date 2020/1/7 19:37
 */
public class BuilderTest {

    public static void main(String[] args) {
        MyBuilder builder=new ConcreteBuilder();
        Director director=new Director(builder);
        Product product=director.construct();
        product.show();
    }
}
