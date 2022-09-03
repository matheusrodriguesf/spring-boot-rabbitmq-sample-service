package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.dto.Message;
import com.example.producer.service.RabbitMQService;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/send")
    public void sendToConsumer(@RequestBody Message message) {
        System.out.println("Message sent to the RabbitMQ");
        rabbitMQService.sendToConsumer(message);
    }
}
