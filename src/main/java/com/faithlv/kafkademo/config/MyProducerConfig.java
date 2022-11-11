package com.faithlv.kafkademo.config;

import com.faithlv.kafkademo.properties.MyProducerProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyProducerConfig {

    //1.获取配置Map
    //2.返回ProducerFactory
    //3.返回ProduceTemplate
    @Autowired
    MyProducerProperties producerProperties;

    public Map<String,Object> getProduceProperties(){
        HashMap<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.CLIENT_ID_CONFIG, producerProperties.id);
        map.put(ProducerConfig.ACKS_CONFIG,producerProperties.acks);
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,producerProperties.servers);
        map.put(ProducerConfig.BATCH_SIZE_CONFIG,producerProperties.size);
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return map;
    }

    public ProducerFactory<String,String> getProducerFactory(){
        return new DefaultKafkaProducerFactory<>(getProduceProperties());
    }

    @Bean("MykafkaTemplate")
    public KafkaTemplate<String,String> kafkaTemplate(){
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(getProducerFactory());
        return kafkaTemplate;
    }

}
