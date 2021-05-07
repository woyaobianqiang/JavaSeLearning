package com.example.aoplog.controller;

import com.example.aoplog.annotation.BusinessLog;
import com.example.aoplog.entity.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsy
 */
@RestController
public class TestAopController {

    @GetMapping("/testAop")
    @BusinessLog(action = "testAop")
    public String testAop(@RequestParam String a) {
        return "ok";
    }

    public static void main(String[] args) {
        TestAopController controller = new TestAopController();
        controller.a();
    }

    @Transactional(rollbackFor = Exception.class)
    public void a () {
//        throw new RuntimeException();
        System.out.println("AAAAA");
    }

}
