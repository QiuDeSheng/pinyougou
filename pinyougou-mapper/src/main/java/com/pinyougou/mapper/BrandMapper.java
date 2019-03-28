package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author QiuDeSheng
 */
public interface BrandMapper {
    @Select("select * from tb_brand order by id asc")
    List<Brand> findAll();
}
