package com.pinyougou.service;

import com.pinyougou.pojo.Brand;

import java.util.List;

/**
 * @author QiuDeSheng
 */
public interface BrandService {
    /**
     * 查询全部品牌
     * @return
     */
    List<Brand> findAll();
}
