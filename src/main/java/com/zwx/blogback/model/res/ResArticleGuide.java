package com.zwx.blogback.model.res;

public class ResArticleGuide {
    private ResSimpleArticle pre;
    private ResSimpleArticle next;

    public ResArticleGuide() {
    }

    public ResArticleGuide(ResSimpleArticle pre, ResSimpleArticle next) {
        this.pre = pre;
        this.next = next;
    }

    public ResSimpleArticle getPre() {
        return pre;
    }

    public void setPre(ResSimpleArticle pre) {
        this.pre = pre;
    }

    public ResSimpleArticle getNext() {
        return next;
    }

    public void setNext(ResSimpleArticle next) {
        this.next = next;
    }
}

