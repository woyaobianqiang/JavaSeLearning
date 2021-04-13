package com.example.easyexcel.easyexceldemo;

import com.alibaba.excel.EasyExcel;
import com.example.easyexcel.easyexceldemo.dto.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EasyexcelDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testWrite() {
        // 文件保存的位置
        String fileName = "D:/test.xlsx";
        EasyExcel.write(fileName, UserVO.class).sheet("用户表").doWrite(list());
    }

    // 简单造写数据，用于测试
    public List<UserVO> list() {
        List<UserVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserVO user = new UserVO();
            user.setUserName("tom" + i);
            user.setAge((int)(Math.random() * 20));
            user.setEmail(user.getUserName() + "@163.com");
            list.add(user);
        }
        return list;
    }

}
