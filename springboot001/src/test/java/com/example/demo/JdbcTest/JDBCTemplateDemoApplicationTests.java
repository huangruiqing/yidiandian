package com.example.demo.JdbcTest;

import com.example.demo.JdbcTemplate001.pojo.HrqBaseDictionary;
import com.example.demo.JdbcTemplate001.service.HrqBaseDictionaryServiceImpl;
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
    private HrqBaseDictionaryServiceImpl hrqBaseDictionaryService;

    /*@Before
    public void setUp() throws Exception {
        hrqBaseDictionary.create();
    }*/

    @Test
    public void test() throws Exception {
        // 插入5个用户
        HrqBaseDictionary hrqBaseDictionary = new HrqBaseDictionary();
        hrqBaseDictionaryService.create(hrqBaseDictionary);


        // 查数据库，应该有5个用户
   //     Assert.assertEquals(5, hrqBaseDictionaryService.create(hrqBaseDictionary));


        // 查数据库，应该有5个用户
        /*Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

        // 删除两个用户
        userSerivce.deleteByName("a");
        userSerivce.deleteByName("e");

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());*/

    }


}
