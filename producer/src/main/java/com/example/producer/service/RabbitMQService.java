package com.example.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producer.amqp.AmpqProducer;
import com.example.producer.dto.Message;

@Service
public class RabbitMQService {

    @Autowired
    private AmpqProducer<Message> ampqProducer;

    public void sendToConsumer(Message message) {
        System.out.println("Message sent to the RabbitMQ: " + message.getMessage());
        ampqProducer.producer(message);
    }
}
