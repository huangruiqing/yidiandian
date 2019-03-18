package com.hrq.dbsmutli.datasourcemulti.dao.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName DynamicRoutingDataSource
 * @Description abstractRoutingDataSource类并且实现determineCurrentLookupKey()方法，设置数据源。
 * @Author huangrq
 * @Date 2019/3/18 14:48
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private static final Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);
    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("当前数据源：{}",DynamicDataSourceContextHolder.get());
        return DynamicDataSourceContextHolder.get();
    }

}
