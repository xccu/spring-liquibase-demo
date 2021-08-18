package com.example.demo.liquibase.controller.base;

import com.example.demo.liquibase.LiquibaseApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.Before;

@SpringBootTest(classes = LiquibaseApplication.class)
public class WebBaseTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public ApplicationContext getApplicationContext() {
        return this.context;
    }
}
