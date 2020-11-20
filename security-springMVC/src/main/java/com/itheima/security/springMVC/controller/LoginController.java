package com.itheima.security.springMVC.controller;

import com.itheima.security.springMVC.model.AuthenticationRequest;
import com.itheima.security.springMVC.model.UserDto;
import com.itheima.security.springMVC.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private AuthenticationService AuthenticationServiceImpl;
    @RequestMapping(value = "/login",method = RequestMethod.POST
            ,produces = "application/json;charset=utf-8")
    public String login(AuthenticationRequest request, HttpSession session){
        UserDto authentication = AuthenticationServiceImpl.authentication(request);
        if(authentication!=null) session.setAttribute("sessionId",authentication);
        return "redirect:/interceptor";
    }


    @RequestMapping(value = "/interceptor",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    public String interceptor(AuthenticationRequest request, HttpSession session){
        return session.getAttribute("sessionId")==null?"error" : "index";
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    public String interceptor(HttpSession session){
        session.invalidate();
        return "redirect:/";
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
