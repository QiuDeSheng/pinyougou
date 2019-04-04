package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author QiuDeSheng
 */

@RestController
@RequestMapping("/brand")
public class BrandController {

    //@Autowired(required=false)
    @Reference(timeout = 10000)
    private BrandService brandService;

    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/findByPage")/*下面为什么不加requestbody或者requestparam*/
    public PageResult findByPage(Brand brand,Integer page, Integer rows){
        //get请求乱码问题
        try {
            if (StringUtils.isNoneBlank(brand.getName())){
                brand.setName(new String(brand.getName().getBytes("ISO8859-1"),"UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  {total:100,rows:{{},{},{}}}
        return brandService.findByPage(brand,page,rows);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Brand brand ){
        try {
            brandService.save(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Brand brand ){
        try {
            brandService.update(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @GetMapping("/delete")
    public boolean delete(Long[] ids){
        try {
            brandService.deleteAll(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @GetMapping("/findBrandList")
    public List<Map<String,Object>> findBrandList(){
        return brandService.findAllByIdAndName();
    }
}
