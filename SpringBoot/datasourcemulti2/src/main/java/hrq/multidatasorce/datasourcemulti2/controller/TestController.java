package hrq.multidatasorce.datasourcemulti2.controller;

import hrq.multidatasorce.datasourcemulti2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
