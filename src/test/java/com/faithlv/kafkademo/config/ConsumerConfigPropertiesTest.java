package com.faithlv.kafkademo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsumerConfigPropertiesTest {

    @Autowired
    ConsumerConfigProperties consumerConfigProperties;

    @Test
    void test1(){
        System.out.println(consumerConfigProperties.getServers());
    }

}
