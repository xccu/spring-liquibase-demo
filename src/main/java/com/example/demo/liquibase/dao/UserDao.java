package com.example.demo.liquibase.dao;

import com.example.demo.liquibase.entity.User;
import com.example.demo.liquibase.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao extends UserMapper {

    @Select("SELECT * FROM liq_user WHERE user_id = #{id}")
    User getUserById(@Param("id") String id);
}
