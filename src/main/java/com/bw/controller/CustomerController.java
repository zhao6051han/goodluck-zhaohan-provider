package com.bw.controller;

import com.bw.bean.Stu;
import com.bw.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赵翰 on 2017/7/28.
 */
@Api
@RestController
public class CustomerController {
    //用在方法上,说明方法的作用
    @ApiOperation(value="获取用户列表" ,notes="不需要参数",httpMethod ="GET" )
    //用在方法上包含一组参数说明
    @ApiImplicitParams({
            @ApiImplicitParam()

    })
    @RequestMapping("/getUserList")
    public @ResponseBody
    List<Stu> getUserList(Long id, Stu s){


        List<Stu> userList = new ArrayList<Stu>();
        return userList;
    }

}
