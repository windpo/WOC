package com.xuyang.wocexample.controller;

import com.xuyang.wocexample.bean.Result;
import com.xuyang.wocexample.bean.User;
import com.xuyang.wocexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private UserService userService;
    /**
     * 获取用户数量
     */
    @GetMapping(value = "/getusercount")
    public Result regist(User user){
        return userService.getuserCount();
    }
    /**
     * 删除用户账号
     */
    @PostMapping(value = "/delete")
    public Result login(User user){
        return userService.delete(user);
    }
}
