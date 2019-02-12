package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MyTask
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/2/11 11:12
 */
public class MyTask implements Runnable {

    public String getDateStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return  sdf.format(date);
    }

    @Override
    public void run() {
      Thread thread  = Thread.currentThread();
        System.out.println(thread.getId()+","+thread.getName()+";"+getDateStr(new Date()));
    }
}
