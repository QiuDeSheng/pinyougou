package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author QiuDeSheng
 */
/*public interface BrandMapper {
    @Select("select * from tb_brand order by id asc")
    List<Brand> findAll();
}*/

public interface BrandMapper extends Mapper<Brand>{

}
