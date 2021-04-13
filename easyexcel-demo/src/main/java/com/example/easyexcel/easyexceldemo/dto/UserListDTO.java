package com.example.easyexcel.easyexceldemo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserListDTO implements Serializable {

    private static final long serialVersionUID = 4109201348129926532L;

    private List<User> userList;

}
