package com.sgb.controller;

import com.sgb.pojo.User;
import com.sgb.pojo.User2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.ErrorManager;

/**
 * @author ***
 * @create 2021-12-31 10:41
 */
@Controller
public class ValidatorCintroller {


    @RequestMapping("/validator/testValidator1")
    public String testValidator1(@Valid User user , BindingResult bindingResult){
        System.out.println("user = " + user);

        return "demo21";
    }

    /**
     *
     * @param user
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping("/validator/testValidator2")
    public String testValidator2(@Valid User user , BindingResult bindingResult,Model model){
        System.out.println("user = " + user);
if (bindingResult.hasErrors()){
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    System.out.println("fieldErrors = " + fieldErrors);
    for (FieldError fieldError : fieldErrors) {
        String fieldName = fieldError.getField();
        String errorMsg = fieldError.getDefaultMessage();
        //错误1 : 生日为空!
        //错误2 : 生日格式错误! 需要处理.
        if ("birthday".equals(fieldName)&&errorMsg.equals("Failes")){
            model.addAttribute(fieldName+"ErrorMsg","生日格式错误");
        }else {
            model.addAttribute(fieldName+"ErrorMsg",errorMsg);

        }
    }
    return "demo22";

}
        return "index";
    }

   /*
    @RequestMapping("/convert/testInvert21")
    public String testInvert21(User2 user2, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String field = fieldError.getField();
            String defaultMessage ="日期错误";*//* fieldError.getDefaultMessage();*//*
            System.out.println("defaultMessage = " + defaultMessage);//错误信息
            System.out.println("field = " + field);//出错字段
            model.addAttribute(field+"ErrorMsg",defaultMessage);
            return "index";
        }
        System.out.println("user2 = " + user2);
        return "index";
        //转发
    }*/

}
