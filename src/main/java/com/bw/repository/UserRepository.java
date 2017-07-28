package com.bw.repository;


import com.bw.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

/**
 * Created by 赵翰 on 2017/7/28.
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    //登录方法
    @Query(value = "select * from user where username=#{username} and pwd=#{pwd}",nativeQuery = true)
    public User login(String username,String pwd);
    //修改
    @Query(value = "update user set username=#{username},pwd=#{pwd},age=#{age},sex=#{sex},hobby=#{hobby} where id=#{id}",nativeQuery = true)
    public void updateUser(User user);

}
