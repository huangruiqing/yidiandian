package com.example.demo.JdbcTemplate001.service;

import com.example.demo.JdbcTemplate001.dao.IHrqBaseDictonary;
import com.example.demo.JdbcTemplate001.pojo.HrqBaseDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName HrqBaseDictionaryImpl
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/13 20:23
 */
@Service
public class HrqBaseDictionaryServiceImpl implements IHrqBaseDictonary {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create(HrqBaseDictionary hrqBaseDictionary) {
        return jdbcTemplate.update("insert into hrq_base_dictionary (code,text,type,status,note) values (?,?,?,?,?)",
                hrqBaseDictionary.getCode(),hrqBaseDictionary.getText(),hrqBaseDictionary.getType(),hrqBaseDictionary.getStatus(),hrqBaseDictionary.getNote());
    }
}
