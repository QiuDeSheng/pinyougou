package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Specification;
import com.pinyougou.service.SpecificationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author QiuDeSheng
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference(timeout =10000)
    private SpecificationService specificationService;

    /**
     * 查询
     */
    @GetMapping("/findByPage")
    public PageResult findByPage(Specification specification,Integer page,Integer rows){
        try {
            if (StringUtils.isNoneBlank(specification.getSpecName())){
                specification.setSpecName(new String(specification.getSpecName().getBytes("ISO8859-1"),"UTF-8"));
            }
            return specificationService.findByPage(specification,page,rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/save")/** 这里为什么要RequestBody */
    public boolean save(@RequestBody Specification specification){
        try {
            specificationService.save(specification);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @GetMapping("/findSpecList")
    public List<Map<String,Object>> findSpecList(){
        return specificationService.findSpecByIdAndName();
    }
}
