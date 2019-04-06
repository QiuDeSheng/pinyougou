package com.pinyougou.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import com.pinyougou.pojo.Seller;

import java.util.List;

/**
 * SellerMapper 数据访问接口
 * @date 2019-03-28 21:40:08
 * @version 1.0
 */
public interface SellerMapper extends Mapper<Seller>{


    //多条件查询商家
    List<Seller> findAll(Seller seller);

    void updateStatus(@Param("sellerId") String sellerId, @Param("status") String status);
}