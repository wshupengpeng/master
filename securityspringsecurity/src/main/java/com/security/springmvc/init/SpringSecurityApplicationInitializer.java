package com.security.springmvc.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityApplicationInitializer extends
        AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitializer(){
//        super(WebSecurityConfig.class);   如果没有springMVC进行配置，则需要手动添加配置。
    }
}
