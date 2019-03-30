package com.pinyougou.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 品牌实体
 * @author QiuDeSheng
 */
@Table(name = "tb_brand")
public class Brand implements Serializable {

    @GeneratedValue(strategy=GenerationType.IDENTITY) //数据库表自增长
    @Id //表示主键列
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column(name = "first_char")
    private String firstChar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
