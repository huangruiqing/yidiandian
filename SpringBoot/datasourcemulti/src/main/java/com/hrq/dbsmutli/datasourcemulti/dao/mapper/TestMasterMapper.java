package com.hrq.dbsmutli.datasourcemulti.dao.mapper;

import com.hrq.dbsmutli.datasourcemulti.dao.config.DataSourceKey;
import com.hrq.dbsmutli.datasourcemulti.dao.config.TargetDataSource;

/**
 * @ClassName TestMasterMapper
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:22
 */
public interface TestMasterMapper {
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
    int getCount();
}
