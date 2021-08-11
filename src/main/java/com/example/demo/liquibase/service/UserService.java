package com.example.demo.liquibase.service;

import com.example.demo.liquibase.dao.UserDao;
import com.example.demo.liquibase.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getById(String id){
        return userDao.getUserById(id);
    }
}
