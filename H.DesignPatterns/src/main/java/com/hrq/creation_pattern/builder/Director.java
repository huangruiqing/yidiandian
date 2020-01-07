package com.hrq.creation_pattern.builder;

/**
 * @ClassName Director
 * @Description 指挥者：调用建造者中的方法完成复杂对象的创建。
 * @Author huangrq
 * @Date 2020/1/7 20:08
 */
public class Director {

    private MyBuilder builder;

    public Director(MyBuilder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }

}
