package com.example.demo;

import com.example.demo.common.MyTestConfig;
import com.example.demo.controller.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  //  private MockMvc mvc;
@Autowired MyTestConfig myTestConfig;
  //  @Before
    public void setUp() throws Exception {
        //mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
 //       mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }


    @Test
    public  void testConfgi() {
        System.out.println(">>>>>>>>>>>>>"+myTestConfig.getTestConfig());
    }

 //   @Test
    public void getIndex() throws Exception {
       // ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON));
     //   resultActions.andExpect(status().isOk());
      //  resultActions.andExpect(content().string(equalTo("index")));
        //mvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
       //         .andExpect(content().string(equalTo("index")));
    }


}
