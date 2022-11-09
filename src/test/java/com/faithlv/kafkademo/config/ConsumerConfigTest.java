package com.faithlv.kafkademo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsumerConfigTest {

    @Autowired
    ConsumerConfig consumerConfig;

    @Test
    void test1(){
        System.out.println(consumerConfig.getServers());
    }

}
