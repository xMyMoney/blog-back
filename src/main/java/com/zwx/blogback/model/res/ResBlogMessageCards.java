package com.zwx.blogback.model.res;

/**
 * 用于返回管理主页卡片信息
 */
public class ResBlogMessageCards {
    /**
     * 已发表文章总数
     */
    private Integer publishCount;

    /**
     * 草稿箱文章总数
     */
    private Integer draftsCount;

    /**
     * 垃圾箱中文章总数
     */
    private Integer deletedCount;

    /**
     * 分类总数
     */
    private Integer categoryCount;

    /**
     * 标签总数
     */
    private Integer tagCount;

    /**
     * 评论总数
     */
    private Integer commentsCount;

    public ResBlogMessageCards() {
    }

    public ResBlogMessageCards(Integer publishCount, Integer draftsCount, Integer deletedCount, Integer categoryCount, Integer tagCount, Integer commentsCount) {
        this.publishCount = publishCount;
        this.draftsCount = draftsCount;
        this.deletedCount = deletedCount;
        this.categoryCount = categoryCount;
        this.tagCount = tagCount;
        this.commentsCount = commentsCount;
    }

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getDraftsCount() {
        return draftsCount;
    }

    public void setDraftsCount(Integer draftsCount) {
        this.draftsCount = draftsCount;
    }

    public Integer getDeletedCount() {
        return deletedCount;
    }

    public void setDeletedCount(Integer deletedCount) {
        this.deletedCount = deletedCount;
    }

    public Integer getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Integer categoryCount) {
        this.categoryCount = categoryCount;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    @Override
    public String toString() {
        return "ResBlogMessageCards{" +
                "publishCount=" + publishCount +
                ", draftsCount=" + draftsCount +
                ", deletedCount=" + deletedCount +
                ", categoryCount=" + categoryCount +
                ", tagCount=" + tagCount +
                ", commentsCount=" + commentsCount +
                '}';
    }
}
