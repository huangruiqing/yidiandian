package com.hrq.creation_pattern.prototype;

/**
 * @ClassName Citation
 * @Description 奖状类
 * @Author huangrq
 * @Date 2019/12/18 19:56
 */
public class Citation implements Cloneable{

    private String studentName;//名字
    private String info;//奖状内容
    private String college;//学院
    public Citation(){}
    public Citation(String studentName , String info ,String college) {
        this.studentName = studentName;
        this.info = info;
        this.college = college;
    }

    public void display() {
        System.out.println(studentName + info + "\t" + college);
    }


    public Object clone() {

        Citation citation = null;
        try {
            citation = (Citation)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Citation clone failed \n"+e);
        }
        return citation;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
