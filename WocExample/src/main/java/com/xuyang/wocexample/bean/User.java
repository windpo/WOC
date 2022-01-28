package com.xuyang.wocexample.bean;

import lombok.Data;

//创建用户信息
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
