package com.example.SpringBootRabbitMQDemo.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TextMessageConsumer {

    @RabbitListener(queues = {"${rabbitmq.plainTextQueue.name}"})
    public void readPublishedMessage(String message) {
       System.out.println("message received : " + message);
    }


}
