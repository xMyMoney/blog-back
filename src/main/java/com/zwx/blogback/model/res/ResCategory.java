package com.zwx.blogback.model.res;

import java.util.Date;

public class ResCategory {
    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
    private Boolean status;
    private Integer articleCount;

    public ResCategory() {
    }

    public ResCategory(Integer id, String name, Date createTime, Date updateTime, Boolean status, Integer articleCount) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.articleCount = articleCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    @Override
    public String toString() {
        return "ResCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", articleCount=" + articleCount +
                '}';
    }
}
