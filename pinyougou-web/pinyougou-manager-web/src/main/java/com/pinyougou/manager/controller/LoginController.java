package com.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QiuDeSheng
 */
@RestController
public class LoginController {

    @GetMapping("/showLoginName")
    public Map<String,String> showLoginName(){
        //获取安全上下文对象
        SecurityContext context = SecurityContextHolder.getContext();
        //获取用户名
        String loginName = context.getAuthentication().getName();

        Map<String,String> data = new HashMap<>();
        data.put("loginName",loginName);
        return data;
    }

}
