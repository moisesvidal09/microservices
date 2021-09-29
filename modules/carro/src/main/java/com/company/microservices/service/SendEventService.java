package com.company.microservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEventService {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public <T> void sendEvent(String topic, T entity){
        kafkaTemplate.send(topic, entity);
    }


}
