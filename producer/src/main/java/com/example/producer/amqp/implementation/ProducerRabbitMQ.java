package com.example.producer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.producer.amqp.AmpqProducer;
import com.example.producer.dto.Message;

@Component
public class ProducerRabbitMQ implements AmpqProducer<Message> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchenge.producer}")
    private String exchange;

    @Override
    public void producer(Message message) {
        System.out.println("Message sent to the RabbitMQ: " + message.getMessage());
        try {
            rabbitTemplate.convertAndSend(exchange, queue, message);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(exchange);
        }
    }
}
