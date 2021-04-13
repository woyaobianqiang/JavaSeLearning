package com.example.redssion.redssiondemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/redisson")
public class RedissonController {

    private static final Logger logger = LogManager.getLogger(RedissonController.class);

    @Autowired
    private RedissonClient redissonClient;

    public static Integer count = 0;

    @PostMapping("test")
    public String testRedisson(){

        RLock lock = redissonClient.getLock("myLock");
        try {

            logger.info("开始加锁");
            count ++;
            logger.info("count ++ 之后的值 {}",count);

            //lock.lock();    //简单的获取锁

            // 获取锁最多等待500ms，10s后key过期自动释放锁
            boolean getLock = lock.tryLock(500,10000, TimeUnit.MILLISECONDS);
            if (!getLock) {
                logger.info("当前线程:[{}]没有获得锁", Thread.currentThread().getName());
                return "failed";
            }
            System.out.println("执行业务");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //lock.isHeldByCurrentThread() 判断当前线程是否持有锁
            if(null != lock && lock.isHeldByCurrentThread()){
                logger.info("解锁:{}"+lock.getName());
                lock.unlock();
            }
        }
        return "success";
    }

}
