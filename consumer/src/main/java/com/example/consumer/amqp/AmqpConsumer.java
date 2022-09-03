package com.example.consumer.amqp;

public interface AmqpConsumer<T> {
    void consumer(T t);
}
