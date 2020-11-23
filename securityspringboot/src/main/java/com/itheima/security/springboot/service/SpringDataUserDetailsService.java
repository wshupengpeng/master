package com.itheima.security.springboot.service;

import com.itheima.security.springboot.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 连接数据库
        List<TbUser> query = jdbcTemplate.query("select * from tb_user where username=?",
                new BeanPropertyRowMapper<TbUser>(TbUser.class), userName);

        for (TbUser tbUser : query) {
            if(tbUser.getUsername().equals(userName)){
              return   User.withUsername(tbUser.getUsername()).password(tbUser.getPassword())
                        .authorities("r1").build();

            }
        }
        throw new UsernameNotFoundException(userName);
    }
}
