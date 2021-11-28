package com.zwx.blogback.model.res;

public class ResBlogInfo {
    private String blogName;
    private String sign;
    private String avatar;
    private Integer articleCount;
    private Integer categoryCount;
    private Integer tagCount;

    public ResBlogInfo() {
    }

    public ResBlogInfo(Integer articleCount, Integer categoryCount, Integer tagCount) {
        this.articleCount = articleCount;
        this.categoryCount = categoryCount;
        this.tagCount = tagCount;
    }

    public ResBlogInfo(String blogName, String sign, String avatar, Integer articleCount, Integer categoryCount, Integer tagCount) {
        this.blogName = blogName;
        this.sign = sign;
        this.avatar = avatar;
        this.articleCount = articleCount;
        this.categoryCount = categoryCount;
        this.tagCount = tagCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
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

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "ResBlogInfo{" +
                "blogName='" + blogName + '\'' +
                ", sign='" + sign + '\'' +
                ", avatar='" + avatar + '\'' +
                ", articleCount=" + articleCount +
                ", categoryCount=" + categoryCount +
                ", tagCount=" + tagCount +
                '}';
    }
}
