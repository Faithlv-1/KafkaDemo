package com.faithlv.kafkademo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka.consumer")
public class ConsumerConfig {

    private String servers;
    private boolean commit;
    private String reset;

}
