package com.springboot.basic;

import com.springboot.basic.controller.HelloController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class SpringCloudBasicApplicationTests {

    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("spring boot hello~")));
    }

}
