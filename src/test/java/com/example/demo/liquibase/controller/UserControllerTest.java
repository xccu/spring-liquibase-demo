package com.example.demo.liquibase.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.liquibase.LiquibaseApplication;
import com.example.demo.liquibase.controller.base.WebBaseTest;
import com.example.demo.liquibase.entity.User;
import com.example.demo.liquibase.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 单元测试示例
 *
 * @author Xie Cangyi
 * @date 2021/8/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiquibaseApplication.class)
@TestPropertySource(
        properties = {
                "spring.datasource.schema[0]=classpath:/schema/liq_user.sql",
                "spring.datasource.data[0]=classpath:/data/liq_user_data.sql"
        })
public class UserControllerTest extends WebBaseTest {

    @Autowired
    private UserService service;

    @Test
    public void testGetAll() throws Exception {
        String url = "/liq/user/";
        // get方法
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);
        // mockHttpServletRequestBuilder.param("id", "1" ); //要传入的参数
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder).andDo(MockMvcResultHandlers.print());
        MvcResult result = resultActions.andReturn();
        String jsonStr = result.getResponse().getContentAsString();
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testGetPageAll() throws Exception {
        String url = "/liq/user/1/2";
        // get方法
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder).andDo(MockMvcResultHandlers.print());
        MvcResult result = resultActions.andReturn();
        String jsonStr = result.getResponse().getContentAsString();
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testGetById() throws Exception {
        String url = "/liq/user/id/1";
        // get方法
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder).andDo(MockMvcResultHandlers.print());
        MvcResult result = resultActions.andReturn();
        String jsonStr = result.getResponse().getContentAsString();
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testGetByName() throws Exception {
        String url = "/liq/user/name/Wolffy";
        // get方法
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder).andDo(MockMvcResultHandlers.print());
        MvcResult result = resultActions.andReturn();
        String jsonStr = result.getResponse().getContentAsString();
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testAdd() throws Exception {

        String url = "/liq/user/add";
        User user = new User();
        user.setUserId(10);
        user.setName("user1");
        user.setSex("male");
        user.setAge(100);

        // post方法
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders.post(url)
                .content(JSON.toJSONString(user))
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder).andDo(MockMvcResultHandlers.print());
        MvcResult result = resultActions.andReturn();
        String jsonStr = result.getResponse().getContentAsString();
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {

        String url = "/liq/user/update";
        User user = new User();
        user.setUserId(6);
        user.setName("Wilie");
        user.setSex("male");
        user.setAge(20);

        // post方法
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders.put(url)
                        .content(JSON.toJSONString(user))
                        .contentType(MediaType.APPLICATION_JSON);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder).andDo(MockMvcResultHandlers.print());
        MvcResult result = resultActions.andReturn();
        String jsonStr = result.getResponse().getContentAsString();
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {

        String url = "/liq/user/delete/6";

        // post方法
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete(url);

        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder).andDo(MockMvcResultHandlers.print());
        MvcResult result = resultActions.andReturn();
        String jsonStr = result.getResponse().getContentAsString();
        resultActions.andExpect(status().isOk());
    }

}
