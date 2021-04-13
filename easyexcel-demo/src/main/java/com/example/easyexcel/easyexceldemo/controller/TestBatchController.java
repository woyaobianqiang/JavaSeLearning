package com.example.easyexcel.easyexceldemo.controller;


import com.example.easyexcel.easyexceldemo.dto.User;
import com.example.easyexcel.easyexceldemo.dto.UserListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestBatchController {

    @GetMapping("/test")
    public void test(@RequestBody User[] users) {
        List<User> users1 = Arrays.asList(users);
//        List<User> userList = userListDTO.getUserList();
        users1.forEach(user -> {
            System.out.println(user.getName());
        });
    }
}
