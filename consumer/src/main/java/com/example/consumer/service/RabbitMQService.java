package com.example.consumer.service;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Service;

import com.example.consumer.dto.Message;

@Service
public class RabbitMQService {
    public void action(Message message) {
        System.out.println("RabbitMQService.action()");
        if ("teste".equalsIgnoreCase(message.getMessage())) {
            throw new AmqpRejectAndDontRequeueException("Erro");
        }
        System.out.println(message.getMessage());
    }

}
