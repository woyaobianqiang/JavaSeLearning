package com.example.redssion.redssiondemo;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissionUtil {
//
//    @Value("${redis.sentinel.host1}")
//    private String sentinelHost1;
//
//    @Value("${redis.sentinel.host2}")
//    private String sentinelHost2;
//
//    @Value("${redis.sentinel.host3}")
//    private String sentinelHost3;
//
//    @Value("${redis.sentinel.port1}")
//    private String sentinelPort1;
//
//    @Value("${redis.sentinel.port2}")
//    private String sentinelPort2;
//
//    @Value("${redis.sentinel.port3}")
//    private String sentinelPort3;

    @Bean
    public RedissonClient redissionClient() {
        Config config = new Config();

        //单机模式
        config.useSingleServer()
                .setAddress("redis://localhost:6379")
//                .setPassword("111")
                .setDatabase(0);

        //集群模式
        /*config.useClusterServers()
                .addNodeAddress("redis://192.168.56.101:36379")
                .addNodeAddress("redis://192.168.56.102:36379")
                .addNodeAddress("redis://192.168.56.103:36379")
                .setPassword("1111111")
                .setScanInterval(5000);*/

        //哨兵模式
//        config.useSentinelServers().addSentinelAddress(
//                "redis://"+ sentinelHost1 + ":" + sentinelPort1,
//                "redis://"+ sentinelHost2 + ":" + sentinelPort2,
//                "redis://"+ sentinelHost3 + ":" + sentinelPort3
//                )
//                .setMasterName("mymaster")
//                //.setPassword("password")
//                .setDatabase(0);

        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }


}
