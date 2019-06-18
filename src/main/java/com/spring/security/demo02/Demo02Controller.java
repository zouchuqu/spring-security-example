package com.spring.security.demo02;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther kklu
 * @date 2019/6/15 16:32
 * @describe
 */

@RestController
@RequestMapping("/demo02")
public class Demo02Controller {

    @GetMapping
    public String hello() {
        return "Hello Spring Security";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('admin')")//指定访问该方法需要的权限/角色(只有 admin 角色能访问)
    public String admin() {
        return "Hello admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('admin','normal')")//指定访问该方法需要的权限/角色(normal或者admin )
    public String user() {
        return "Hello user";
    }

}