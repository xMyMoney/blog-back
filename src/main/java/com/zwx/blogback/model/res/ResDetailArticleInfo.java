package com.zwx.blogback.model.res;

import com.zwx.blogback.model.Article;
import com.zwx.blogback.model.Category;
import com.zwx.blogback.model.Tag;

import java.util.List;

public class ResDetailArticleInfo {
    private Article article;
    private Category category;
    private List<Tag> tags;
    private ResArticleGuide pn;

    public ResDetailArticleInfo() {
    }

    public ResDetailArticleInfo(Article article, Category category, List<Tag> tags, ResArticleGuide pn) {
        this.article = article;
        this.category = category;
        this.tags = tags;
        this.pn = pn;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public ResArticleGuide getPn() {
        return pn;
    }

    public void setPn(ResArticleGuide pn) {
        this.pn = pn;
    }

    @Override
    public String toString() {
        return "ResArticleInfo{" +
                "article=" + article +
                ", category=" + category +
                ", tags=" + tags +
                ", pn=" + pn +
                '}';
    }
}
