package com.hrq.dbsmutli.datasourcemulti.dao.mapper;

import com.hrq.dbsmutli.datasourcemulti.dao.config.TargetDataSource;

/**
 * @ClassName TestMasterDao
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:22
 */

public interface TestMasterMapper {
    @TargetDataSource(value = "master")
    int getCount();
    @TargetDataSource(value = "master")
    int save();
}
