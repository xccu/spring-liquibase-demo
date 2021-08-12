package com.example.demo.liquibase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("liq_user")
public class User {

    @TableId(value = "USER_ID")
    private Integer userId;
    @TableField(value = "NAME")
    private String name;
    @TableField(value = "AGE")
    private Integer age;
    @TableField(value = "SEX")
    private String sex;
}
