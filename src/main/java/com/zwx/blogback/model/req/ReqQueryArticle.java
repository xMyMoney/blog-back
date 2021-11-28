package com.zwx.blogback.model.req;

public class ReqQueryArticle {
    private String by;
    private Integer status;
    private Integer categoryId;
    private Integer tagId;
    private Integer page;
    private Integer pageSize;

    public ReqQueryArticle() {
    }

    public ReqQueryArticle(String by, Integer status, Integer categoryId, Integer tagId, Integer page, Integer pageSize) {
        this.by = by;
        this.status = status;
        this.categoryId = categoryId;
        this.tagId = tagId;
        this.page = page;
        this.pageSize = pageSize;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ReqQueryArticle{" +
                "by='" + by + '\'' +
                ", status=" + status +
                ", categoryId=" + categoryId +
                ", tagId=" + tagId +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
