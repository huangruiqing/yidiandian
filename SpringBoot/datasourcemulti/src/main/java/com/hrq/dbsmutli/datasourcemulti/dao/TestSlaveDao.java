package com.hrq.dbsmutli.datasourcemulti.dao;

import com.hrq.dbsmutli.datasourcemulti.dao.mapper.TestSlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestSlaveDao
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:22
 */
@Component
public class TestSlaveDao {
    @Autowired
    private TestSlaveMapper testSlaveMapper;

    public int getCount(){
        return testSlaveMapper.getCount();
    }

    //@Transactional(value = "db_tm")
    public int save(){
        return testSlaveMapper.save();
    }

}
