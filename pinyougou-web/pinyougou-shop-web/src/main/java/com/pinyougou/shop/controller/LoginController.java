package com.pinyougou.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author QiuDeSheng
 */
@Controller
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;


    /** 登录的方法*/
    @RequestMapping("/login")
    public String longin(String username, String password, String code, HttpServletRequest request){
        try {
            System.out.println("输入的用户名"+ username);
            System.out.println("输入的密码"+ password);
            System.out.println("输入的验证码"+ code);

            //判断请求方法
            if ("post".equalsIgnoreCase(request.getMethod())){
                //获取验证码
                String oldCode = (String) request.getSession().getAttribute(VerifyController.VERIFY_CODE);
                //判断验证码
                if (code.equalsIgnoreCase(oldCode)){
                    //判断角色和权限,登录

                    //创建用户名和密码凭证
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
                    //认证
                    Authentication authenticate = authenticationManager.authenticate(token);

                    //判断是否认证成功
                    if (authenticate.isAuthenticated()){
                        //安全上下文设置认证对象
                        SecurityContextHolder.getContext().setAuthentication(authenticate);
                        return "redirect:/admin/index.html";
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/shoplogin.html";
    }

    @GetMapping("/showLoginName")
    @ResponseBody
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
