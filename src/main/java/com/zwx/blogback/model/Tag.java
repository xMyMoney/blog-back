package com.zwx.blogback.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class Tag implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * 标签id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 状态，0表示正常，1表示删除，默认0
     */
    private Boolean status;


    public Tag() {
    }

    public Tag(Integer id, String name, Date createTime, Date updateTime, Boolean status) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tag(Integer id, Boolean status) {
        this.id = id;
        this.status = status;
    }



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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
