package com.example.demo.JdbcTemplate001.dao;

import com.example.demo.JdbcTemplate001.pojo.HrqBaseDictionary;

/**
 * @ClassName IHrqBaseDictonaryDao
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/13 20:15
 */
public interface IHrqBaseDictonaryDao {

    /**
     * 新增一个字典
     */
    int create(HrqBaseDictionary hrqBaseDictionary);


}
