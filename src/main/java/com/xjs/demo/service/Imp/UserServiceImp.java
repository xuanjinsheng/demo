package com.xjs.demo.service.Imp;

import com.github.pagehelper.PageHelper;
import com.xjs.demo.mybatis.mapper.UserMapper;
import com.xjs.demo.po.pojo.User;
import com.xjs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectByExample(null);
    }

    @Override
    public int insertUser(User user) {
        System.out.println("现在时间是" + LocalDateTime.now().toString());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int i = userMapper.insertSelective(user);
        if(i > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int updateUser(Integer id, User user) {

        user.setId(id);
        user.setUpdateTime(new Date());
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String getUserInfoByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        return user.getPassword();
    }
}
