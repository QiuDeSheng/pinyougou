package com.pinyougou.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author QiuDeSheng
 */
public class PageResult implements Serializable{
    private long total;//总记录数
    private List<?> rows;//分页数据

    public PageResult() {
    }

    public PageResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
