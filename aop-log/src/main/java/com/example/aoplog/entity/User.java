package com.example.aoplog.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * @author admin
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4931730672025754338L;

    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
