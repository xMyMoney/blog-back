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
public class Comments implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 父id, 默认0
     */
    private Integer parentId;

    /**
     * 回复的评论id
     */
    private Integer replyId;

    /**
     * 评论者名称
     */
    private String name;

    /**
     * 评论者邮箱
     */
    private String email;

    /**
     * 评论内容json
     */
    private String content;

    /**
     * 评论内容（原始内容）
     */
    private String sourceContent;

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
     * 状态，0正常，1删除，默认0
     */
    private Boolean status;

    /**
     * 是否是作者，0否，1是，默认0
     */
    private Boolean isAuthor;

    public Comments() {
    }

    public Comments(Integer id, String articleId, Integer parentId, Integer replyId, String name, String email, String content, String sourceContent, Date createTime, Date deleteTime, Boolean status, Boolean isAuthor) {
        this.id = id;
        this.articleId = articleId;
        this.parentId = parentId;
        this.replyId = replyId;
        this.name = name;
        this.email = email;
        this.content = content;
        this.sourceContent = sourceContent;
        this.createTime = createTime;
        this.deleteTime = deleteTime;
        this.status = status;
        this.isAuthor = isAuthor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSourceContent() {
        return sourceContent;
    }

    public void setSourceContent(String sourceContent) {
        this.sourceContent = sourceContent;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getAuthor() {
        return isAuthor;
    }

    public void setAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }

    @Override
    public String toString() {
        return "Comments{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", parentId=" + parentId +
        ", replyId=" + replyId +
        ", name=" + name +
        ", email=" + email +
        ", content=" + content +
        ", sourceContent=" + sourceContent +
        ", createTime=" + createTime +
        ", deleteTime=" + deleteTime +
        ", status=" + status +
        ", isAuthor=" + isAuthor +
        "}";
    }
}
