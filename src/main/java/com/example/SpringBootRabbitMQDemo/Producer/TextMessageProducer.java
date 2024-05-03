package com.example.SpringBootRabbitMQDemo.Producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TextMessageProducer {

    @Value("${rabbitmq.plainTextExchange.name}")
    private String simpleTextExchangeName;
    @Value("${rabbitmq.plainTextRoutingKey.name}")
    private String simpleTextRoutingKeyName;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public String produce(String message) {
        rabbitTemplate.convertAndSend(simpleTextExchangeName, simpleTextRoutingKeyName, message);
        return "message send";
    }
}
