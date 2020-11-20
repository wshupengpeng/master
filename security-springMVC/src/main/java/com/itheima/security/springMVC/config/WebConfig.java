package com.itheima.security.springMVC.config;

import com.itheima.security.springMVC.filter.EncodingFilter;
import com.itheima.security.springMVC.interceptor.SimpleAuthenticationInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration  // 相当于spring-mvc.xml文件
@EnableWebMvc
@ComponentScan(basePackages = "com.itheima.security.springMVC")
//        ,includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class))
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private SimpleAuthenticationInteceptor inteceptor;
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver=
                new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(inteceptor)
                .addPathPatterns("/r/*");
    }
}
