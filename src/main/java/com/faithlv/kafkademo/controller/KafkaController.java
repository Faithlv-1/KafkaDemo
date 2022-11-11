package com.faithlv.kafkademo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class KafkaController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/test")
    public String test(@RequestParam("msg") String msg){
        kafkaTemplate.send("topic_1","key_1",msg);
        return "send ok";
    }

    @GetMapping("/test2")
    public String test2(){
        return "ok";
    }

    @KafkaListener(id = "1",groupId = "group_1",topics = "topic_1",containerFactory = "MykafkaContainer")
    public void listener(String msg){
        log.info("listen msg:{}",msg);
    }
}
