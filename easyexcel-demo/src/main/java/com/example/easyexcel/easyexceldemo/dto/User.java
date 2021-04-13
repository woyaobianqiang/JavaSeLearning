package com.example.easyexcel.easyexceldemo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2896489166149084455L;

    private String name;

    private String sex;

}
