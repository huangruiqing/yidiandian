package com.example.demo.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.Map;

/**
 *  freemaker 使用freemaker 模板引擎
 */
@RestController()
@ApiIgnore
@EnableAutoConfiguration
public class FTLController {
    @Autowired
    private Configuration configuration;
    @RequestMapping("/ftl")
    public String welcome2(Map model) throws Exception {
        model.put("time", new Date());
        model.put("message", "freemaker_test");

        Template template = configuration.getTemplate("welcome.ftl");
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        System.out.println(content);

        return content;
    }



}