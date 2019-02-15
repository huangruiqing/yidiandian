package com.huang.datasourcemulti.controller;

import com.huang.datasourcemulti.Service.SysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestController
 * @Description
 * @Author huangrq
 * @Date 2019/2/15 14:13
 */
@RestController
public class TestController {

    @Autowired
    private SysAccountService myListService;

    @RequestMapping("test")
    public String test() {
        Map<String,Object> param = new HashMap<>();
        param.put("name","huang");
        List<String> codes = new ArrayList<>();
        codes.add("1");
        codes.add("2");
        codes.add("3");
        param.put("codes",codes);
        List<String> stringList =   myListService.getList(param);
        System.out.println(stringList);
        return stringList.size()+"";
    }
}
