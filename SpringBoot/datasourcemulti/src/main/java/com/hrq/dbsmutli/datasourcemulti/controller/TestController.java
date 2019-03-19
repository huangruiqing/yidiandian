package com.hrq.dbsmutli.datasourcemulti.controller;

import com.hrq.dbsmutli.datasourcemulti.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

/**
 * @ClassName TestController
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:44
 */
@RestController
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping(value = {"/", ""})
    public int test() {
        return testService.getCount();
    }

    @RequestMapping("save")
    public int saveTest() {
        testService.save();
        return 0;
    }
}
