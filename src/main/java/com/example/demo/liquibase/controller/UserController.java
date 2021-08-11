package com.example.demo.liquibase.controller;

import com.example.demo.liquibase.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/sst/user")
public class UserController {

    @Autowired
    UserService userService;


}
