package com.hrq.dbsmutli.datasourcemulti.dao.mapper;

import com.hrq.dbsmutli.datasourcemulti.dao.config.DataSourceKey;
import com.hrq.dbsmutli.datasourcemulti.dao.config.TargetDataSource;

/**
 * @ClassName TestSlaveMapper
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:22
 */

public interface TestSlaveMapper {
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
    int getCount();

}
