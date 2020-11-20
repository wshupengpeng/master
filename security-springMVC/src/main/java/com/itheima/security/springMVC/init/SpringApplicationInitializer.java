package com.itheima.security.springMVC.init;

import com.itheima.security.springMVC.config.ApplicationConfig;
import com.itheima.security.springMVC.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 加载spring容器，相当于加载applicationContext.xml
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }
    // 加载servletContext  相当于加载SpringMVC.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    // 获取URLMapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
