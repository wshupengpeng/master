package com.itheima.security.springMVC.interceptor;

import com.itheima.security.springMVC.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Component
public class SimpleAuthenticationInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object object = session.getAttribute("sessionId");
        if(object==null){
            response.sendRedirect("/");
            return false;
        }
        UserDto user=(UserDto)object;
        Set<String> auth = user.getAuth();
        String contextPath = request.getRequestURI();

        if(auth.contains("p1") && contextPath.contains("/r/r1") ){
            return true;
        }else if(auth.contains("p2") && contextPath.contains("/r/r2") ){
            return true;
        }
        response.sendRedirect("/");
        return false;
    }
}
