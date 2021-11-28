package com.zwx.blogback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
public class Friends implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 友链id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 友链名称
     */
    private String name;

    /**
     * 对应链接
     */
    private String url;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 状态，0表示可用，1表示删除，默认0
     */
    private Boolean status;

    /**
     * 所属分类id
     */
    private Integer typeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                ", status=" + status +
                ", typeId=" + typeId +
                '}';
    }
}
