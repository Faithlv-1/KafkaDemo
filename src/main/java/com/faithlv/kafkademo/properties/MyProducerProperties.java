package com.faithlv.kafkademo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "das.producer")
public class MyProducerProperties {

    public String servers;
    public String acks;
    public String id;
    public int size;
}
