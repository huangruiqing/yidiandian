package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName Dog
 * @Description
 * @Author huangrq
 * @Date 2020/1/2 19:56
 */
public class Dog implements IAnimal {
    @Override
    public void walk() {
        System.out.println("this dog is walking");
    }

    @Override
    public void voice() {
        System.out.println("this dog is voicing");
    }
}
