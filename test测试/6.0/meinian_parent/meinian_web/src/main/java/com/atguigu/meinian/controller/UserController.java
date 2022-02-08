package com.atguigu.meinian.controller;

import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2022/1/22
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUsername")
    public Result getUsername(){
        try{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,user.getUsername());
        }catch (Exception e){
            return new Result(false, MessageConstant.GET_USERNAME_FAIL);
        }
    }

}
