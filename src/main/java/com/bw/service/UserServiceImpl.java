package com.bw.service;

import com.bw.bean.User;
import com.bw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 赵翰 on 2017/7/28.
 */
@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(String username, String pwd) {
        return userRepository.login(username,pwd);
    }

    @Override
    public void addUser(User user) {
      userRepository.save(user);
    }

    @Override
    public List<User> queryUser() {
        return userRepository.findAll();
    }

    @Override
    public void delUser(Integer id) {
       userRepository.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }



    @Override
    public User queryOne(Integer id) {
        return userRepository.findOne(id);
    }


}
