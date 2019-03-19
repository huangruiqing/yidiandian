package com.hrq.dbsmutli.datasourcemulti.service;

import com.hrq.dbsmutli.datasourcemulti.dao.TestMasterDao;
import com.hrq.dbsmutli.datasourcemulti.dao.TestSlaveDao;
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
    private TestMasterDao testMasterDao;
    @Autowired
    private TestSlaveDao testSlaveDao;

    public int getCount() {
        int i = new Random().nextInt(3);
        System.out.println(">>>>>>>>>>>>>>" + i);
        if (i > 1) {
            System.out.println("slave db");
            return testSlaveDao.getCount();
        }
        System.out.println("master db");
        return testMasterDao.getCount();
    }


    public void save() {
        testMasterDao.save();
        testSlaveDao.save();
    }
}
