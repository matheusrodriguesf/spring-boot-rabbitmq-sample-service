package com.example.consumer.service;

import org.springframework.stereotype.Service;

import com.example.consumer.dto.Message;

@Service
public class RabbitMQService {
    public void action(Message message) {
        System.out.println("RabbitMQService.action()");
        System.out.println(message.getMessage());

    }

}
