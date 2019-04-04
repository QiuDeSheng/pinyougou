package com.pinyougou.service;

import com.pinyougou.pojo.ItemCat;

import java.util.List;

/**
 * @author QiuDeSheng
 */
public interface ItemCatService {
    List<ItemCat> findItemCatByParentId(Long parentId);
}
