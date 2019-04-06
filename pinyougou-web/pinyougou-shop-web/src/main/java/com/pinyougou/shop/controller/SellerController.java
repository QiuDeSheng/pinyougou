package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Seller;
import com.pinyougou.service.SellerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuDeSheng
 */

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference(timeout = 10000)
    private SellerService sellerService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping("/save")
    public boolean save(@RequestBody Seller seller){
        try {
            String password = passwordEncoder.encode(seller.getPassword());
            seller.setPassword(password);
             sellerService.save(seller);
             return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String s = DigestUtils.md5Hex("123456");
        System.out.println(s);
    }
}
