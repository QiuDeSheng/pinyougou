package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.mapper.SpecificationMapper;
import com.pinyougou.mapper.SpecificationOptionMapper;
import com.pinyougou.pojo.Specification;
import com.pinyougou.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author QiuDeSheng
 */
@Service(interfaceName = "com.pinyougou.service.SpecificationService")
@Transactional
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;
    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;


    @Override
    public void save(Specification specification) {
        //往tb_specification插数据
        specificationMapper.insertSelective(specification);
        System.out.println("主键id:" + specification.getId());

        //往tb_specification_option插数据
        /*for (SpecificationOption specificationOption : specification.getSpecificationOptions()) {
            specificationOption.setSpecId(specification.getId());
            specificationOptionMapper.insertSelective(specificationOption);
        }*/
        specificationOptionMapper.save(specification);
    }

    @Override
    public void update(Specification specification) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void deleteAll(Serializable[] ids) {

    }

    @Override
    public Specification findOne(Serializable id) {
        return null;
    }

    @Override
    public List<Specification> findAll() {
        return null;
    }

    @Override
    public PageResult findByPage(Specification specification, int page, int rows) {

        try {
            PageInfo<Specification> pageInfo = PageHelper.startPage(page, rows).doSelectPageInfo(new ISelect() {
                @Override
                public void doSelect() {
                    specificationMapper.findAll(specification);
                }
            });
            return new PageResult(pageInfo.getTotal(),pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> findSpecByIdAndName() {
        try {

            return specificationMapper.findSpecByIdAndName();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
