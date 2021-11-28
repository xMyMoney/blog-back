package com.zwx.blogback.model.req;

public class ReqSecret {
    private Integer id;
    private String key;

    public ReqSecret() {
    }

    public ReqSecret(Integer id, String key) {
        this.id = id;
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ReqSecret{" +
                "id=" + id +
                ", key='" + key + '\'' +
                '}';
    }
}
