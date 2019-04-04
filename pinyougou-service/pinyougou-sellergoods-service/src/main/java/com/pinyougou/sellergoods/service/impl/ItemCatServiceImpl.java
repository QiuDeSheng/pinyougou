package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.ItemCatMapper;
import com.pinyougou.pojo.ItemCat;
import com.pinyougou.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author QiuDeSheng
 */
@Service(interfaceName = "com.pinyougou.service.ItemCatService")
@Transactional
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;


    @Override
    public List<ItemCat> findItemCatByParentId(Long parentId) {
        try {
            return itemCatMapper.findItemCatByParentId(parentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
