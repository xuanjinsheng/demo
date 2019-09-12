package com.xjs.demo.controller;

import com.xjs.demo.po.pojo.User;
import com.xjs.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Api(tags = "UserController", description = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户",  httpMethod = "POST", produces = "application/json")
    public Object insertUser(User user){

        int i = userService.insertUser(user);
        logger.info("新增用户");
        if(i == 1){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
}
