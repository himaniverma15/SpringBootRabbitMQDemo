package com.example.SpringBootRabbitMQDemo.Producer;

import com.example.SpringBootRabbitMQDemo.Model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageProducer {

    @Value("${rabbitmq.jsonTextExchange.name}")
    private String jsonExchangeName;
    @Value("${rabbitmq.jsonRoutingKey.name}")
    private String jsonRoutingKeyName;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void publis̥h(User user) {
        rabbitTemplate.convertAndSend(jsonExchangeName, jsonRoutingKeyName, user);
        System.out.println("message publish : " + user.toString());
    }
}
