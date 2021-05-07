package com.example.rabbitmq.service;

import com.example.aoplog.api.IExtBusinessLogUser;
import com.example.aoplog.dto.BusinessLogUser;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class UserService implements IExtBusinessLogUser {

    @Override
    public BusinessLogUser getUser() {
        BusinessLogUser user = new BusinessLogUser();
        user.setUserId("1");
        user.setUserName("zsy");
        return user;
    }
}
