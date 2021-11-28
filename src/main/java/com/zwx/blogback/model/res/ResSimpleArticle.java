package com.zwx.blogback.model.res;

public class ResSimpleArticle {
    private Integer id;
    private String title;

    public ResSimpleArticle() {
    }

    public ResSimpleArticle(Integer id, String title) {
        this.id = id;
        this.title = title;
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

    @Override
    public String toString() {
        return "SimpleArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
