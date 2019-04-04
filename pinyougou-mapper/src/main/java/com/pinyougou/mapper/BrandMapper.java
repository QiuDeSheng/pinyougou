package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author QiuDeSheng
 */
/*public interface BrandMapper {
    @Select("select * from tb_brand order by id asc")
    List<Brand> findAll();
}*/

public interface BrandMapper extends Mapper<Brand>{

    /**
     * 多条件查询品牌
     * @param brand
     * @return
     */
    List<Brand> findAll(Brand brand);

    //批量删除
    void deleteAll(@Param("ids") Serializable[] ids);

    @Select("select id ,name as text from tb_brand ")
    List<Map<String,Object>> findAllByIdAndName();
    /*void deleteAll( Serializable[] ids);*/
}
