package com.faithlv.kafkademo.config;

import com.faithlv.kafkademo.properties.MyConsumerProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Component
public class MyConsumerConfig {

    //1.返回配置Map<String,Object>
    //2.返回ComsumerFactory
    //3.返回KafkaTemplate
    @Autowired
    MyConsumerProperties consumerProperties;
    public Map<String,Object> getConsumerConfigs(){
        HashMap<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerProperties.servers);
        map.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,consumerProperties.commit);
        map.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,consumerProperties.reset);
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        return map;
    }

    public ConsumerFactory<String,String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<String,String>(getConsumerConfigs());
    }

    @Bean("MykafkaContainer")
    public ConcurrentKafkaListenerContainerFactory listenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(5);
        factory.setBatchListener(true);
        return factory;
    }
}
