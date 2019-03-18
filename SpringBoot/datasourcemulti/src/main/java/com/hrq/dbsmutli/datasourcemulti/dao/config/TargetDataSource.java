package com.hrq.dbsmutli.datasourcemulti.dao.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName TargetDataSource
 * @Description 自定义数据源注解(类，接口或方法)
 * @Author huangrq
 * @Date 2019/3/18 15:14
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    DataSourceKey dataSourceKey() default DataSourceKey.DB_MASTER;
}
