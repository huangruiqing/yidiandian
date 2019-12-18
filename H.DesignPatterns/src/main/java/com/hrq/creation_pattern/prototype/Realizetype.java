package com.hrq.creation_pattern.prototype;

/**
 * @ClassName Realizetype
 * @Description
 * @Author huangrq
 * @Date 2019/12/18 19:49
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("Realizetype init done");
    }

    public Object clone() {
        Realizetype realizetype = null;
        try {
            realizetype = (Realizetype) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("克隆失败 Realizetype:\n"+e);
        }
        return  realizetype;
    }
}
