package com.pinyougou.pojo;

import javax.persistence.*;

/**
 * TypeTemplate 实体类
 * @date 2019-03-28 21:08:06
 * @version 1.0
 */
@Table(name = "tb_type_template")
public class TypeTemplate implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String name;
	@Column(name = "spec_ids")
	private String specIds;
	@Column(name = "brand_ids")
	private String brandIds;
	@Column(name = "custom_attribute_items")
	private String customAttributeItems;

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setSpecIds(String specIds){
		this.specIds = specIds;
	}
	public String getSpecIds(){
		return this.specIds;
	}
	public void setBrandIds(String brandIds){
		this.brandIds = brandIds;
	}
	public String getBrandIds(){
		return this.brandIds;
	}
	public void setCustomAttributeItems(String customAttributeItems){
		this.customAttributeItems = customAttributeItems;
	}
	public String getCustomAttributeItems(){
		return this.customAttributeItems;
	}

}