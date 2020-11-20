package com.itheima.security.springMVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserDto {

    // 用户的身份信息
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;

    private Set<String> auth;

}
