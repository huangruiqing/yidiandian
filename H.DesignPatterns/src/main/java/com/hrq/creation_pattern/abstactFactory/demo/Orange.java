package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName Orange
 * @Description
 * @Author huangrq
 * @Date 2020/1/2 19:57
 */
public class Orange implements IPlant  {
    @Override
    public void bloom() {
        System.out.println("Orange is blooming");
    }

    @Override
    public void bearFruit() {
        bloom();
        System.out.println("Orange is bear fruit");
    }
}
