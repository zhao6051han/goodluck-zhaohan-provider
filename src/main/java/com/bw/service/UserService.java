package com.bw.service;

import com.bw.bean.User;

import java.util.List;

/**
 * Created by 赵翰 on 2017/7/28.
 */
public interface UserService {
    //登录方法
    public User login(String username,String pwd);
    //注册方法
    public void addUser(User user);
    //查询全部信息
    public List<User> queryUser();
    //删除
    public void delUser(Integer id);
    //修改
    public void updateUser(User user);
    //查询一条数据
    public User queryOne(Integer id);
}
