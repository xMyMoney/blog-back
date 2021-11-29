package com.zwx.blogback.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章分类id
     */
    private String categoryId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 删除时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date deleteTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 状态，0-正常（发布），1-删除，2-记录（待发布）
     */
    private Byte status;

    /**
     * 内容
     */
    private String content;

    /**
     * 生成的html
     */
    private String htmlContent;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 文章简介
     */
    private String subMessage;

    /**
     * 文章阅读数
     */
    private Integer pageview;

    /**
     * 是否加密，0否，1是，默认0
     */
    private Boolean isEncrypt;

    public Article() {
    }

    public Article(Integer id, Integer pageview) {
        this.id = id;
        this.pageview = pageview;
    }

    public Article(Integer id, String title, String content, String htmlContent, String cover, String subMessage, Boolean isEncrypt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlContent = htmlContent;
        this.cover = cover;
        this.subMessage = subMessage;
        this.isEncrypt = isEncrypt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public Boolean getEncrypt() {
        return isEncrypt;
    }

    public void setEncrypt(Boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", createTime=" + createTime +
                ", deleteTime=" + deleteTime +
                ", updateTime=" + updateTime +
                ", publishTime=" + publishTime +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", cover='" + cover + '\'' +
                ", subMessage='" + subMessage + '\'' +
                ", pageview=" + pageview +
                ", isEncrypt=" + isEncrypt +
                '}';
    }
}
