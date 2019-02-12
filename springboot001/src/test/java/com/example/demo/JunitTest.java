package com.example.demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName JunitTest
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/14 14:45
 */
public class JunitTest {

    @Test
    public void testCalder() {
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        //获取上个月的数据
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        cal_1.set(Calendar.HOUR_OF_DAY, 0);
        cal_1.set(Calendar.MINUTE, 0);
        cal_1.set(Calendar.SECOND, 0);
        cal_1.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(cal_1.getTime());
        System.out.println(dateStr);


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date time = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(time);
        System.out.println(format);


    }

}
