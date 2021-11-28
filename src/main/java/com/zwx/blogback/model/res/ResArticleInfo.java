package com.zwx.blogback.model.res;

import com.zwx.blogback.model.Article;
import com.zwx.blogback.model.Category;
import com.zwx.blogback.model.Tag;

import java.util.List;

public class ResArticleInfo {
    private Article article;
    private Category category;
    private List<Tag> tags;

    public ResArticleInfo() {
    }

    public ResArticleInfo(Article article, Category category, List<Tag> tags) {
        this.article = article;
        this.category = category;
        this.tags = tags;
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

    @Override
    public String toString() {
        return "ResArticleInfo{" +
                "article=" + article +
                ", category=" + category +
                ", tags=" + tags +
                '}';
    }
}
