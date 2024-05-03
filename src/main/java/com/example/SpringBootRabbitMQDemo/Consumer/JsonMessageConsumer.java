package com.example.SpringBootRabbitMQDemo.Consumer;

import com.example.SpringBootRabbitMQDemo.Model.User;
import com.example.SpringBootRabbitMQDemo.Producer.JsonMessageProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageConsumer {

    JsonMessageProducer jsonMessageProducer;

    @RabbitListener(queues = {"${rabbitmq.jsonQueue.name}"})
    public void readPublishedMessage(User user){
        System.out.println("message reveived :" + user.toString());
    }
}
