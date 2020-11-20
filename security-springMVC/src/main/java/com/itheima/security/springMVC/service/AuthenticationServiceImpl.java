package com.itheima.security.springMVC.service;

import com.itheima.security.springMVC.model.AuthenticationRequest;
import com.itheima.security.springMVC.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
     static Map<String,UserDto> param=new HashMap<>();
    static {
        Set<String> auth1=new HashSet<>();
        auth1.add("p1");
        param.put("张三",new UserDto("1","zhangshan"
                ,"123","456","1341515124",auth1));
        Set<String> auth2=new HashSet<>();
        auth2.add("p2");
        param.put("李四",new UserDto("2","lisi","234",
                "234","1234124515",auth2));
    }
    /**
     * 校验用户身份信息是否合法
     * @param authenticationRequest 用户认证请求
     * @return
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest==null
        || StringUtils.isEmpty(authenticationRequest.getUsername())
        || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("账号密码为空");
        }
        //根据账户去查询数据库，此处采用模拟方法
        String username = authenticationRequest.getUsername();
        if(param.containsKey(username)
                && param.get(username).getPassword()
                .equals(authenticationRequest.getPassword())){
            return param.get(username);
        }
        return null;
    }

}
