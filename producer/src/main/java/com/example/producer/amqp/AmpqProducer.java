package com.example.producer.amqp;

public interface AmpqProducer<T> {
    void producer(T t);
}
