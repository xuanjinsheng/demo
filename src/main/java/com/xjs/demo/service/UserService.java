package com.xjs.demo.service;

import com.xjs.demo.po.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    /**
     * 获取所有用户
     * @return
     */
    List<User> getList(int pageNum, int pageSize);

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Transactional
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param id
     * @param user
     * @return
     */
    @Transactional
    int updateUser(Integer id , User user);

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    String getUserInfoByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User getUserByUsernameAndPassword(String username, String password) throws Exception;

}
