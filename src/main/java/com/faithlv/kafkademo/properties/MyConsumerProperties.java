package com.faithlv.kafkademo.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MyConsumerProperties {

    @Value("${das.consumer.servers}")
    public String servers;
    @Value("${das.consumer.commit}")
    public boolean commit;
    @Value("${das.consumer.reset}")
    public String reset;

}
