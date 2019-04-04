package com.pinyougou.mapper;

import com.pinyougou.pojo.TypeTemplate;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * TypeTemplateMapper 数据访问接口
 * @date 2019-03-28 21:40:08
 * @version 1.0
 */
public interface TypeTemplateMapper extends Mapper<TypeTemplate>{

    List<TypeTemplate> findAll(TypeTemplate typeTemplate);

    void deleteAll(@Param("ids") Serializable[] ids);
}