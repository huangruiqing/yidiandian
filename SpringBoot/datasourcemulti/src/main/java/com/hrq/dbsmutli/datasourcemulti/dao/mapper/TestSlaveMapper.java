package com.hrq.dbsmutli.datasourcemulti.dao.mapper;

import com.hrq.dbsmutli.datasourcemulti.dao.config.TargetDataSource;

/**
 * @ClassName TestSlaveDao
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:22
 */

public interface TestSlaveMapper {
    @TargetDataSource(value = "slave1")

    int getCount();
    @TargetDataSource(value = "slave1")
    int save();

}
