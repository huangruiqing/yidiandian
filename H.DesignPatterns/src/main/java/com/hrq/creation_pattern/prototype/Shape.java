package com.hrq.creation_pattern.prototype;

/**
 * @ClassName Shap
 * @Description 形状
 * @Author huangrq
 * @Date 2019/12/18 20:13
 */
public interface Shape extends Cloneable {

    Object clone();
    void countArea();//计算面积

}
