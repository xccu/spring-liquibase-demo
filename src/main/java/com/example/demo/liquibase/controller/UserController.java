package com.example.demo.liquibase.controller;

import com.example.demo.liquibase.entity.User;
import com.example.demo.liquibase.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/liq/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAll() {
        List<User> users = userService.getAll();
        return users;
    }

    @GetMapping("/id/{id}")
    public User getById(@PathVariable String id) {
        User user = userService.getById(id);
        return user;
    }

    @GetMapping("/name/{name}")
    public User getByName(@PathVariable String name) {
        User user = userService.getByName(name);
        return user;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        try {
            return userService.addOne(user);
        }catch (Exception ex){
            return null;
        }
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        try {
            return userService.update(user);
        }catch (Exception ex){
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        try {
            userService.deleteById(id);
            return "Success";
        }catch (Exception ex){
            return "Failed";
        }
    }
}
