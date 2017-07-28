package com.bw.controller;

import com.bw.bean.User;
import com.bw.service.UserService;
import com.bw.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 赵翰 on 2017/7/28.
 */
@Controller
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    /**
     * 主页 登录页面
     */
    @RequestMapping("/goToLogin")
    public String goToLogin(){

        //int i=1/0;

        return "login.html";
    }
    /**
     * 跳转到注册页面
     */
    @RequestMapping("/goToAdd")
    public String goToAdd(){
        return "add.html";
    }
    /**
     * 登录方法
     */
    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session){
        User u = userService.login(username, pwd);
        System.out.print(u);
        if(u != null){
            session.setAttribute("u",u);
            return "forward:findUser";
        }
        return "error.html";
    }
    /**
     * 注册方法
     */
    @RequestMapping("/insert")
    public String insert(User user){
        System.out.print(user);
        userService.addUser(user);
        return "forward:findUser";
    }
    /**
     * 查询全部信息
     */
    @RequestMapping("/findUser")
    public String find(Model model){
        List<User> users = userService.queryUser();
        model.addAttribute("users",users);
        return "find.html";
    }
    /**
     * 查询一条记录
     */
    @RequestMapping("/findOne")
    public String  findOne(Integer id,Model model){
        User user = userService.queryOne(id);
        model.addAttribute("user",user);
        return "update.html";
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "forward:findUser";
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public String deleteUser(Integer id){
        userService.delUser(id);
        return "forward:findUser";
    }


    //Redis实验
    @RequestMapping("/selectUserByName")
    public User selectUserByName(Integer id){
        User user = null;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        Boolean exists = redisTemplate.hasKey("user");
        if(exists){
            user =  operations.get("user");

            System.out.println("exists is true" + user.getId());
        }else{

            user = userService.queryOne(id);
            operations.set("user",user);
            System.out.println("exists is false");
        }
        return user;

    }
    @RequestMapping("/getUserName")
    public User getUserName(Integer id){

        return  userService.queryOne(id);
    }

}
