package com.example.SpringBootRabbitMQDemo.Controller;

import com.example.SpringBootRabbitMQDemo.Model.User;
import com.example.SpringBootRabbitMQDemo.Producer.JsonMessageProducer;
import com.example.SpringBootRabbitMQDemo.Producer.TextMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {

    @Autowired
    TextMessageProducer textMessageProducer;

    @Autowired
    JsonMessageProducer jsonMessageProducer;

    @PostMapping(value = "/text/publish")
    public void publish(@RequestParam("message") String message){
        textMessageProducer.produce(message);
    }

    @PostMapping(value = "/json/publish")
    public void publishJsonMessage(@RequestBody User user){
        jsonMessageProducer.publis̥h(user);
        System.out.println("message publish");
    }
}
