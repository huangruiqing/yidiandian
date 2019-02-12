package com.example.demo.valid;

/**
 * @ClassName Order
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/1/16 19:06
 */
public class Order {

    @PxxRequiredRule(required = true, exceptionMsg = "手机号码不能为空")
    @PxxFixLengthRule(fixLength = 11, exceptionMsg = "手机号码必须为11位")
    private String phoneNum;//手机号码
    @PxxMustNumber(isNum = true, exceptionMsg = "充值金额必须为数字")
    private String payMent;//支付金额
    private String create_time;//创建时间

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPayMent() {
        return payMent;
    }

    public void setPayMent(String payMent) {
        this.payMent = payMent;
    }

    @Override
    public String toString() {
        return "phoneNum=" + getPhoneNum() + ",Create_time=" + getCreate_time() + ",PayMent=" + getPayMent();
    }

}
