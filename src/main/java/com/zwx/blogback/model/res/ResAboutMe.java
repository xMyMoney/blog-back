package com.zwx.blogback.model.res;

public class ResAboutMe {
    private String html;

    public ResAboutMe(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "ResAboutMe{" +
                "html='" + html + '\'' +
                '}';
    }
}
