package com.zwx.blogback.model.req;

public class ReqBlogConfig {
    private Integer id;
    private String blogName;
    private String avatar;
    private String sign;
    private String wxpayQrcode;
    private String alipayQrcode;
    private String github;
    private Boolean settingPassword;
    private String newPassword;
    private String oldPassword;

    public ReqBlogConfig() {
    }

    public ReqBlogConfig(Integer id, String blogName, String avatar, String sign, String wxpayQrcode, String alipayQrcode, String github, Boolean settingPassword, String newPassword, String oldPassword) {
        this.id = id;
        this.blogName = blogName;
        this.avatar = avatar;
        this.sign = sign;
        this.wxpayQrcode = wxpayQrcode;
        this.alipayQrcode = alipayQrcode;
        this.github = github;
        this.settingPassword = settingPassword;
        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
    }

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

    public Boolean getSettingPassword() {
        return settingPassword;
    }

    public void setSettingPassword(Boolean settingPassword) {
        this.settingPassword = settingPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @Override
    public String toString() {
        return "ReqBlogConfig{" +
                "id=" + id +
                ", blogName='" + blogName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sign='" + sign + '\'' +
                ", wxpayQrcode='" + wxpayQrcode + '\'' +
                ", alipayQrcode='" + alipayQrcode + '\'' +
                ", github='" + github + '\'' +
                ", settingPassword=" + settingPassword +
                ", newPassword='" + newPassword + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                '}';
    }
}
