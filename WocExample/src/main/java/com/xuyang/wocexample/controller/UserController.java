package com.xuyang.wocexample.controller;

import com.xuyang.wocexample.bean.Result;
import com.xuyang.wocexample.bean.User;
import com.xuyang.wocexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller层：负责具体业务模块流程的控制，即调用Service层的接口来控制业务流程。负责url映射（action）。（对接前端）
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //创建userService对象，调用userService的方法，将user对象传给userService,返回函数调用的结果
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/regist")
    public Result regist(User user){
        return userService.regist(user);
    }
    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/login")
    public Result login(User user){
        return userService.login(user);
    }
}
