package com.itheima.security.springMVC.model;

import lombok.Data;

@Data
public class AuthenticationRequest {
    //认证请求参数
    private String username;

    private String password;



}
