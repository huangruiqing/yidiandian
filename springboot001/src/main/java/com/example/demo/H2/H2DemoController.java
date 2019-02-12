package com.example.demo.H2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName H2DemoController
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/18 19:29
 */
@RestController
@RequestMapping("/h2")
public class H2DemoController {

    @Autowired
    private DemoInfoRepository demoInfoRepository;

    @RequestMapping("add")
    public List<DemoInfo> save() {
        DemoInfo demoInfo = demoInfoRepository.save(new DemoInfo("title1", "context1"));
        DemoInfo demoInfo2 = demoInfoRepository.save(new DemoInfo("title2", "context2"));
        DemoInfo demoInfo3 = demoInfoRepository.save(new DemoInfo("title3", "context3"));
        DemoInfo demoInfo4 = demoInfoRepository.save(new DemoInfo("title4", "context4"));

        List<DemoInfo> list = new ArrayList<>();
        list.add(demoInfo);
        list.add(demoInfo2);
        list.add(demoInfo3);
        list.add(demoInfo4);
        return list;
    }

    @RequestMapping("/all")
    public List<DemoInfo> findAll() {
        List<DemoInfo> list = (List<DemoInfo>) demoInfoRepository.findAll();
        return list;
    }

    @RequestMapping("/find/{id}")
    public DemoInfo findById(@PathVariable Long id) {
        Optional<DemoInfo> demoInfo = demoInfoRepository.findById(id);
        if (!demoInfo.isPresent()) {
            return demoInfo.orElse(new DemoInfo("不存在id:" + id, ""));
        }
        return demoInfo.get();
    }

}
