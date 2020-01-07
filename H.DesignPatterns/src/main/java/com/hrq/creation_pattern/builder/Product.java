package com.hrq.creation_pattern.builder;

/**
 * @ClassName Product
 * @Description 产品角色：包含多个组成部件的复杂对象。
 * @Author huangrq
 * @Date 2020/1/7 19:57
 */
public class Product {

    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println(partA);
    }

}
