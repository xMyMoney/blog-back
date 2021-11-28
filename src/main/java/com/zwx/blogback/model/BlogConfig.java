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
public class BlogConfig implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 博客名称
     */
    private String blogName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 微信支付二维码
     */
    private String wxpayQrcode;

    /**
     * 支付宝支付二维码
     */
    private String alipayQrcode;

    /**
     * github
     */
    private String github;

    /**
     * 阅读加密密码
     */
    private String viewPassword;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getWxpayQrcode() {
        return wxpayQrcode;
    }

    public void setWxpayQrcode(String wxpayQrcode) {
        this.wxpayQrcode = wxpayQrcode;
    }

    public String getAlipayQrcode() {
        return alipayQrcode;
    }

    public void setAlipayQrcode(String alipayQrcode) {
        this.alipayQrcode = alipayQrcode;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getViewPassword() {
        return viewPassword;
    }

    public void setViewPassword(String viewPassword) {
        this.viewPassword = viewPassword;
    }

    @Override
    public String toString() {
        return "BlogConfig{" +
                "id=" + id +
                ", blogName='" + blogName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sign='" + sign + '\'' +
                ", wxpayQrcode='" + wxpayQrcode + '\'' +
                ", alipayQrcode='" + alipayQrcode + '\'' +
                ", github='" + github + '\'' +
                ", viewPassword='" + viewPassword + '\'' +
                '}';
    }
}
