package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName Cat
 * @Description
 * @Author huangrq
 * @Date 2020/1/2 19:56
 */
public class Cat implements IAnimal {
    @Override
    public void walk() {
        System.out.println("this Cat is walking");
    }

    @Override
    public void voice() {
        System.out.println("this Cat is voicing");
    }
}
