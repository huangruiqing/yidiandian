package com.hrq.creation_pattern.prototype;

/**
 * @ClassName Circle
 * @Description 圆形
 * @Author huangrq
 * @Date 2019/12/18 20:17
 */
public class Circle implements Shape{

    private double r;

    public  Circle(double r){
        this.r = r;
    };
    public  Circle(){};

    @Override
    public Object clone() {
        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("clone circle failed");
        }
        return circle;
    }

    @Override
    public void countArea() {
        double area = Math.pow(r,2)*Math.PI;
        System.out.println("计算圆形面积"+area);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
