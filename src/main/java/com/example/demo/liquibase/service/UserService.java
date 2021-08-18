package com.example.demo.liquibase.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.liquibase.dao.UserDao;
import com.example.demo.liquibase.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getById(String id){
        return userDao.getUserById(id);
    }

    public User getByName(String name){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);
        return userDao.selectOne(wrapper);
    }

    public List<User> getAll(){
        return userDao.selectList(null);
    }

    public PageInfo getPageAll(int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list =  userDao.selectList(null);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    public User addOne(User user) {
        int count = userDao.insert(user);
        if (count == 1) {
            return user;
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public User update(User user) throws Exception {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getUserId());
        int count = userDao.update(user,wrapper);
        //int count = userDao.updateByIdSelective(user);
        if (count != 1) {
            throw new Exception("操作失败");
        }
        return userDao.selectById(user.getUserId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(String id) throws Exception {
        int count = userDao.deleteById(id);
        if (count != 1) {
            throw new Exception("操作失败");
        }
    }

}
