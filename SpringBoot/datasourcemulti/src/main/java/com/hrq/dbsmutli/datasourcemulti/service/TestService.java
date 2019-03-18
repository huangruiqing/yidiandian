package com.hrq.dbsmutli.datasourcemulti.service;

import com.hrq.dbsmutli.datasourcemulti.dao.mapper.TestMasterMapper;
import com.hrq.dbsmutli.datasourcemulti.dao.mapper.TestSlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName TestService
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:45
 */
@Service
public class TestService {

    @Autowired
    private TestMasterMapper testMasterMapper;
    @Autowired
    private TestSlaveMapper testSlaveMapper;

    public int getCount() {
        int i = new Random().nextInt(3);
        System.out.println(">>>>>>>>>>>>>>"+i);
        if (i > 1) {
            System.out.println("slave db");
            return testSlaveMapper.getCount();
        }
        System.out.println("master db");
        return testMasterMapper.getCount();
    }
}
