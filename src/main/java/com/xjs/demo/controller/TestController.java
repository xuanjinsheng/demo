package com.xjs.demo.controller;


import com.xjs.demo.commontResult.ResultGenerator;
import com.xjs.demo.po.pojo.User;
import com.xjs.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@Api(value = "TestController", tags = {"测试示例"})
public class TestController {

    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @RequestMapping( value = "/get/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户", httpMethod = "GET", produces = "application/json")
    public Object userList(@PathVariable int pageNum, @PathVariable int pageSize){
        List<User> user = userService.getList(pageNum, pageSize);
        logger.info("获取所有用户");
        return ResultGenerator.genSuccessResult(user);
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        logger.info("欢迎语");
        return  "以后得使劲努力了！！！！";
    }
}
