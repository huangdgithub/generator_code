package com.mf.glory.utils;


/**
 * @Author: MuFeng
 * @CreateDate: 2019/3/29 14:58
 */
public class BasePageQuery {

    private Integer pageSize = 20;
    private Integer pageNum;

    public Integer getPage() {
        if (pageSize == null || pageSize.intValue() <= 0) {
            pageSize = 20;
        } else if (pageSize > 1000) {
            pageSize = 200;
        }
        return pageSize;
    }

    public Integer getPageNum() {
        if (pageNum == null || pageNum.intValue() <= 0) {
            pageNum = 1;
        }
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
