package com.zwx.blogback.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Pages implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 页面名称
     */
    private String type;

    /**
     * markdown内容
     */
    private String md;

    /**
     * 生成的html内容
     */
    private String html;

    public Pages() {
    }

    public Pages(Integer id, String type, String md, String html) {
        this.id = id;
        this.type = type;
        this.md = md;
        this.html = html;
    }

    public Pages(Integer id, String md, String html) {
        this.id = id;
        this.md = md;
        this.html = html;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "Pages{" +
        "id=" + id +
        ", type=" + type +
        ", md=" + md +
        ", html=" + html +
        "}";
    }
}
