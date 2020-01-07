package com.hrq.creation_pattern.builder;

/*
 * @ClassName MyBuilder
 * @Description   抽象建造者：包含创建产品各个子部件的抽象方法。
 * @Author huangrq
 * @Date 2020/1/7 20:06
 **/
public abstract class MyBuilder {

    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }

}
