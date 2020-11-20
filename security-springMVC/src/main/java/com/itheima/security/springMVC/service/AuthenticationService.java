package com.itheima.security.springMVC.service;

import com.itheima.security.springMVC.model.AuthenticationRequest;
import com.itheima.security.springMVC.model.UserDto;

public interface AuthenticationService {

    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);

}
