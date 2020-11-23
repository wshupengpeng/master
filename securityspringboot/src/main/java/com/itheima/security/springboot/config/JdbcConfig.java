package com.itheima.security.springboot.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class JdbcConfig {
  /*  @Autowired
    private DataSource dataSource;*/

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new ComboPooledDataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
            return new JdbcTemplate(dataSource);
    }
}
