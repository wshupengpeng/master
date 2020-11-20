//package com.itheima.security.springboot.service;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SpringDataUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        // 连接数据库
//        System.out.println(userName);
//        UserDetails build = User.withUsername("zhangsan")
//                .password("$2a$10$kXjz6HojCmtNTPTsBOvV2u7gTXZrlqCcvIOF9oFzpjsYXvVTu71xi")
//                .authorities("p1").build();
//        return build.getUsername().equals(userName)? build:null;
//    }
//}
