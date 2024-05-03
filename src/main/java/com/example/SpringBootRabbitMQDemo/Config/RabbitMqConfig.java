package com.example.SpringBootRabbitMQDemo.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.plainTextQueue.name}")
    private String simpleTextQueueName;
    @Value("${rabbitmq.plainTextExchange.name}")
    private String simpleTextExchangeName;
    @Value("${rabbitmq.plainTextRoutingKey.name}")
    private String simpleTextRoutingKeyName;

    @Value("${rabbitmq.jsonQueue.name}")
    private String jsonQueueName;
    @Value("${rabbitmq.jsonTextExchange.name}")
    private String jsonExchangeName;
    @Value("${rabbitmq.jsonRoutingKey.name}")
    private String jsonRoutingKeyName;

    @Bean
    Queue simpleTextQueue(){
        return  new Queue(simpleTextQueueName);
    }

    @Bean
    Queue jsonQueue(){
        return  new Queue(jsonQueueName);
    }

    @Bean
    TopicExchange simpleTextExchange(){
        return new TopicExchange(simpleTextExchangeName);
    }

    @Bean
    TopicExchange jsonExchange(){
        return  new TopicExchange(jsonExchangeName);
    }

    @Bean
    Binding simpleTextBinding(){
       return BindingBuilder.bind(simpleTextQueue())
                .to(simpleTextExchange())
                .with(simpleTextRoutingKeyName);

    }

    @Bean
    Binding jsonBinding(){
        return  BindingBuilder.bind(jsonQueue())
                .to(jsonExchange())
                .with(jsonRoutingKeyName);
    }

    @Bean
    MessageConverter messageConverter(){
        return new  Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
