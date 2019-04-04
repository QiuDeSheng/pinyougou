package com.pinyougou.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.TypeTemplate;

import java.io.Serializable;

/**
 * @author QiuDeSheng
 */
public interface TypeTemplateService {

    PageResult findByPage(TypeTemplate typeTemplate,Integer page,Integer rows);

    void save(TypeTemplate typeTemplate);

    void update(TypeTemplate typeTemplate);

    void deleteAll(Serializable[] ids);
}
