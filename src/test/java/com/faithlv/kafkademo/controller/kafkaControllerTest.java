package com.faithlv.kafkademo.controller;

import com.faithlv.kafkademo.KafkaDemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

import javax.annotation.Resource;
import java.io.IOException;


@SpringBootTest(classes = KafkaDemoApplication.class)
@EmbeddedKafka(ports = {9092})
@Slf4j
public class kafkaControllerTest {

    @Resource
    KafkaTemplate<String,String> mykafkaTemplate;

    @Test
    void test1() {
        log.info("--开始发送消息--");
        mykafkaTemplate.send("topic_1","key_1","data_1");
        mykafkaTemplate.send("topic_2","key_1","data_2");
        log.info("--消息发送完毕--");
    }

}
