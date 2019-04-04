package com.pinyougou.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author QiuDeSheng
 */
public interface BrandService {
    /**
     * 查询全部品牌
     * @return
     */
    List<Brand> findAll();

    void save(Brand brand);

    void update(Brand brand);

    PageResult findByPage(Brand brand, Integer page, Integer rows);

    void deleteAll(Serializable[] ids);

    List<Map<String,Object>> findAllByIdAndName();
}
