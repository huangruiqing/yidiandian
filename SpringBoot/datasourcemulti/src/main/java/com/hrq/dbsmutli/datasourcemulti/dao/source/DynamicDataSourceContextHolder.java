package com.hrq.dbsmutli.datasourcemulti.dao.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DynamicDataSourceContextHolder
 * @Description 这个类是为了解决多线程访问全局变量的问题
 * @Author huangrq
 * @Date 2019/3/18 14:41
 */
public class DynamicDataSourceContextHolder {
    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);
    private static final ThreadLocal<String> currentDatesource = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static String get() {
        return currentDatesource.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(String value) {
        currentDatesource.set(value);
    }

    /**
     * 设置从从库读取数据
     * 采用简单生成随机数的方式切换不同的从库
     */
    public static void setSlave() {
     //   DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE1);
       /* if (new Random().nextInt(2) > 0) {
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE2);
        } else {
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE1);
        }*/
    }

}
