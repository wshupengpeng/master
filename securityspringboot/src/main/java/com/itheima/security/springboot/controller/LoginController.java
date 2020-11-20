package com.itheima.security.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


@Controller
@RequestMapping
public class LoginController {
    @RequestMapping(value = "/login-success")
    @ResponseBody
    public String loginSuccess(){
        return "success";
    }
    @RequestMapping(value = "/download",method = {RequestMethod.GET,RequestMethod.POST})
    public String download(HttpServletResponse response, HttpServletRequest request){
        String method = request.getMethod();
        System.out.println(method);
        File file=new File("D:\\资料数据\\简历资料\\张芮_Java开发_本科_CET-4.docx");
        byte [] data=new byte[1024];
        if(file.exists()){
            try (FileInputStream fileOutputStream=new FileInputStream(file);){
                ServletOutputStream outputStream = response.getOutputStream();
                int i;
                while((i=fileOutputStream.read(data))!=-1){
                    outputStream.write(data);
                }
                outputStream.flush();
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("success");
        }
        response.reset();
        return "index";
    }

    @RequestMapping(value = "/r/r1",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    @ResponseBody
    @PreAuthorize("isAnonymous()")  //匿名访问

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
