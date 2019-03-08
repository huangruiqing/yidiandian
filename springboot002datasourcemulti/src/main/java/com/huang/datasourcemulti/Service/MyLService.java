package com.huang.datasourcemulti.Service;

import com.huang.datasourcemulti.dao.MyLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MyListService
 * @Description
 * @Author huangrq
 * @Date 2019/2/15 14:15
 */
@Service
public class MyLService {

    @Autowired
    private MyLMapper myLMapper;

    public List<String> getList(Map<String,Object> param) {

        return myLMapper.getList(param);
    }



}
