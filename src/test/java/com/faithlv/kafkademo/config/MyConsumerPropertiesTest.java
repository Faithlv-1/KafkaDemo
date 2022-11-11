package com.faithlv.kafkademo.config;

import com.faithlv.kafkademo.properties.MyConsumerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyConsumerPropertiesTest {

    @Autowired
    MyConsumerProperties myConsumerProperties;



}
