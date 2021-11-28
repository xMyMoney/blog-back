package com.zwx.blogback.model.common;

import java.util.List;

/**
 * 根据前端设计的分页。。。
 * @param <T>
 */
public class PageBean<T> {
    private Integer count;
    private List<T> list;

    public PageBean(Integer count, List<T> list) {
        this.count = count;
        this.list = list;
    }

    public PageBean(List<T> list) {
        this.count = list.size();
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }
}
