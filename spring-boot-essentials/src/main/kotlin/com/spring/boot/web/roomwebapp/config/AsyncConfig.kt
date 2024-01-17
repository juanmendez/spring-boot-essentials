package com.spring.boot.web.roomwebapp.config

import com.spring.boot.web.roomwebapp.async.RoomCleanerListener
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Suppress("unused")
@Configuration
class AsyncConfig {
    companion object {
        private const val QUEUE_NAME = "room-cleaner"
        private const val EXCHANGE_NAME = "operations"
        private const val ROUTING_KEY = "lisbon.rooms.cleaner"
        private const val DELIVERED_RECEIVED_METHOD = "receiveMessage"
    }

    @Bean
    fun queue() = Queue(QUEUE_NAME, false)

    @Bean
    fun exchange() = TopicExchange(EXCHANGE_NAME)

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding? {
        return BindingBuilder
            .bind(queue)
            .to(exchange)
            .with(ROUTING_KEY)
    }

    @Bean
    fun listenerAdapter(listener: RoomCleanerListener): MessageListenerAdapter {
        return MessageListenerAdapter(listener, DELIVERED_RECEIVED_METHOD)
    }

    @Bean
    fun container(connectionFactory: ConnectionFactory, listenerAdapter: MessageListenerAdapter): SimpleMessageListenerContainer {
        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.setQueueNames(QUEUE_NAME)
        container.setMessageListener(listenerAdapter)

        return container
    }
}