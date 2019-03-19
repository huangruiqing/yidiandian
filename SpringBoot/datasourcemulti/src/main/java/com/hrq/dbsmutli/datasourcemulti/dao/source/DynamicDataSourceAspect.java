package com.hrq.dbsmutli.datasourcemulti.dao.source;

import com.hrq.dbsmutli.datasourcemulti.dao.config.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName DynamicDataSourceAspect
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 15:17
 */
@Aspect
@Order(0)
@Component
public class DynamicDataSourceAspect {
    private static final Logger LOG = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Pointcut("execution(* com.hrq.dbsmutli.datasourcemulti.dao.mapper.*.*(..))")
    public void pointCut() {
    }

    /**
     * 执行方法前更换数据源
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @Before("@annotation(targetDataSource)")
    public void doBefore(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        String dataSourceKey = targetDataSource.value();
        if (!"master".equals(dataSourceKey)) {
            LOG.info(String.format("设置数据源为  %s", dataSourceKey));
            DynamicDataSourceContextHolder.set(dataSourceKey);
        } else {
            LOG.info(String.format("设置数据源为默认数据源  %s","master"));
        }
    }

    /**
     * 执行方法后清除数据源设置
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @After("@annotation(targetDataSource)")
    public void doAfter(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        LOG.info(String.format("当前数据源  %s  执行清理方法", targetDataSource.value()));
        DynamicDataSourceContextHolder.clear();
    }



}
