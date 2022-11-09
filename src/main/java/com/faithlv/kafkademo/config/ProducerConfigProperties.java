package com.faithlv.kafkademo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka.producer")
public class ProducerConfigProperties {

    private String servers;
    private int acks;
    private String id;
    private int size;
}
