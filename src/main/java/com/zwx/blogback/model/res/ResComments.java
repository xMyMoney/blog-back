package com.zwx.blogback.model.res;

import com.zwx.blogback.model.Comments;

import java.util.Date;
import java.util.List;

public class ResComments {
    private Integer id;
    private String avatar;
    private String name;
    private Date createTime;
    private String content;
    private List<Comments> children;

    public ResComments() {
    }

    public ResComments(Integer id, String avatar, String name, Date createTime, String content, List<Comments> children) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.createTime = createTime;
        this.content = content;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comments> getChildren() {
        return children;
    }

    public void setChildren(List<Comments> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ResComments{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", children=" + children +
                '}';
    }
}
