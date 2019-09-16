package com.xjs.demo.service;

import com.xjs.demo.po.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 获取所有用户
     * @return
     */
    List<User> getList();

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param id
     * @param user
     * @return
     */
    int updateUser(Integer id , User user);

}
