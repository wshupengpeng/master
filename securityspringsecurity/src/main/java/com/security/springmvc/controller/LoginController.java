package com.security.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping
public class LoginController {
    @RequestMapping(value = "/login-success")
    @ResponseBody
    public String loginSuccess(){
        return "success";
    }

    @RequestMapping(value = "/r/r1",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String r1(){
        return "访问r1成功";
    }

    @RequestMapping(value = "/r/r2",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String r2(){
        return "访问r2成功";
    }
}
