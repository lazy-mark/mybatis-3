package com.zsj.mybatis.custom;

import java.io.Serializable;

/**
 * @desc:
 * @author: zhangshengjun
 * @createDate: 2021/1/10
 */
public class Cat implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
