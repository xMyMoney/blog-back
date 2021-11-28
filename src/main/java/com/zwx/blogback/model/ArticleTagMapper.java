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
public class ArticleTagMapper implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 标签id
     */
    private Integer tagId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    public ArticleTagMapper() {
    }

    public ArticleTagMapper(Integer id, Integer articleId, Integer tagId, Date createTime) {
        this.id = id;
        this.articleId = articleId;
        this.tagId = tagId;
        this.createTime = createTime;
    }

    public ArticleTagMapper(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ArticleTagMapper{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", tagId=" + tagId +
                ", createTime=" + createTime +
                '}';
    }
}
