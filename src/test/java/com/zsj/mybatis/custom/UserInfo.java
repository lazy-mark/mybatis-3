package com.zsj.mybatis.custom;

import java.io.Serializable;

/**
 * @desc:
 * @author: zhangshengjun
 * @createDate: 2021/1/10
 */
public class UserInfo implements Serializable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
