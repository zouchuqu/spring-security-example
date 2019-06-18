package com.spring.security.demo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @auther kklu
 * @date 2019/6/17 11:51
 * @describe
 */

@EnableWebSecurity//开启Spring Security 功能
@Configuration//配置类注解
@EnableGlobalMethodSecurity(prePostEnabled=true)//开启方法安全级别控制
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //spring 5.0 之前//spring 5.0之后基于内存配置多用户
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        /*
//         * 配置为从内存中进行加载认证信息.
//         * 这里配置了两个用户 admin 和 user
//         */
////        auth.inMemoryAuthentication().withUser("admin").password("123456").roles();
//        auth.inMemoryAuthentication().withUser("user").password("123456").roles();
//    }

    //spring 5.0之后基于内存配置多用户
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(new BCryptPasswordEncoder().encode("123456"))
//                .roles();
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(new BCryptPasswordEncoder().encode("123456"))
//                .roles();
//    }

    //给每个用户配置权限
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("admin");
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("normal");
    }


}
