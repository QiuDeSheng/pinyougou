package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.ItemCat;
import com.pinyougou.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author QiuDeSheng
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference( timeout = 10000)
    private ItemCatService itemCatService;

    @RequestMapping("/findItemCatByParentId")
    public List<ItemCat> findItemCatByParentId(Long parentId){
        try {
            return itemCatService.findItemCatByParentId(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
