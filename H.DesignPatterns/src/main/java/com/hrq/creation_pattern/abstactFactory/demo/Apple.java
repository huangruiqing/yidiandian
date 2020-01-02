package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName Apple
 * @Description
 * @Author huangrq
 * @Date 2020/1/2 19:57
 */
public class Apple implements IPlant  {
    @Override
    public void bloom() {
        System.out.println("Apple is blooming");
    }

    @Override
    public void bearFruit() {
        bloom();
        System.out.println("Apple is bear fruit");
    }
}
