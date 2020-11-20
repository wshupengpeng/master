package com.itheima.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//   定义用户信息服务（查询用户信息）  基于内存的信息验证
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("$2a$10$3BI4wFzQRf1Hlrj6CHncxexXa6PvfVEehr1xZqjjbHrv1TTjTXMQW").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }

    // 密码编辑器 (选择不加密比对)
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 安全拦截机制（最重要的）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()  // 所有/r/**请求全部需要认证通过
                .anyRequest().permitAll()//其他不做限制
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login-view")
                .loginProcessingUrl("/login")
                .successForwardUrl("/login-success");//自定义登录成功的页面地址
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
    }


}
