package com.example.consumer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.consumer.amqp.AmqpConsumer;
import com.example.consumer.dto.Message;
import com.example.consumer.service.RabbitMQService;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

    @Autowired
    private RabbitMQService rabbitMQService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(Message message) {
        System.out.println("RabbitMQConsumer.consumer()");
        try {
            rabbitMQService.action(message);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
