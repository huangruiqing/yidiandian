package com.example.demo.JdbcTest;

import com.example.demo.JdbcTemplate001.dao.IHrqBaseDictonaryDao;
import com.example.demo.JdbcTemplate001.pojo.HrqBaseDictionary;
import com.example.demo.JdbcTemplate001.dao.impl.HrqBaseDictionaryDaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBCTemplateDemoApplicationTests {

    @Autowired
    private IHrqBaseDictonaryDao hrqBaseDictionaryDao;


    @Test
    public void test() throws Exception {
        // 插入5个用户
        HrqBaseDictionary hrqBaseDictionary = new HrqBaseDictionary();
        hrqBaseDictionary.setText("汉字测试1");
       int con = hrqBaseDictionaryDao.create(hrqBaseDictionary);
        System.out.println("res:"+con);
       // Assert.
        // 查数据库，应该有5个用户
       // Assert.assertEquals(5, hrqBaseDictionaryDao.create(hrqBaseDictionary));


        // 查数据库，应该有5个用户
        /*Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

        // 删除两个用户
        userSerivce.deleteByName("a");
        userSerivce.deleteByName("e");

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());*/

    }


}
