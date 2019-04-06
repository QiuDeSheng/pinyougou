package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务接口实现类
 * @author QiuDeSheng
 */
@Service(interfaceName ="com.pinyougou.service.BrandService" )
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public void save(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public PageResult findByPage(Brand brand, Integer page, Integer rows) {
        try {
            //开启分页
            PageInfo<Brand> pageInfo= PageHelper.startPage(page,rows).doSelectPageInfo(new ISelect() {
                @Override
                public void doSelect() {
                    brandMapper.findAll(brand);
                }
            });

            return new PageResult(pageInfo.getTotal(),pageInfo.getList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll(Serializable[] ids) {
        try {
            /*for (Serializable id : ids) {
                delete(id);
            }*/

            brandMapper.deleteAll(ids);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    @Override//[{id:'1',text:'华为'},{id:'2',text:'apple'},{id:'3',text:'小米'}]
    public List<Map<String, Object>> findAllByIdAndName() {
        try {
            /*List<Brand> brandList = findAll();
            List<Map<String,Object>> data = new ArrayList<>();
            for (Brand brand : brandList) {
                Map<String,Object> map = new HashMap<>();
                map.put("id",brand.getId());
                map.put("text",brand.getName());
                data.add(map);
            }
            return data;*/

            return brandMapper.findAllByIdAndName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
