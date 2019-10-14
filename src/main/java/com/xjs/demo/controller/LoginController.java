package com.xjs.demo.controller;

import com.xjs.demo.commontResult.Result;
import com.xjs.demo.commontResult.ResultGenerator;
import com.xjs.demo.po.pojo.User;
import com.xjs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Result login(@RequestParam String username, @RequestParam String password) throws Exception {

        if(username == null || password == null){
            throw new Exception("用户名或密码不能为空");
        }else {
            User user = userService.getUserByUsernameAndPassword(username, password);
            if(user != null){
                return ResultGenerator.genSuccessResult(user);
            }else {
                return ResultGenerator.genFailResult("用户不存在");
            }
        }
    }
}
