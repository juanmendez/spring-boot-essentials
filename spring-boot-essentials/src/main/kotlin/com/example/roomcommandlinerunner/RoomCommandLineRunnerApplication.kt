package com.example.roomcommandlinerunner

import com.example.roomcommandlinerunner.models.Room
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class RoomCommandLineRunnerApplication {
    companion object {
        val LOG: Logger = LoggerFactory.getLogger(RoomCommandLineRunnerApplication::class.java)
    }

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()

    @Bean
    @Throws(RestClientException::class)
    fun run(restTemplate: RestTemplate): CommandLineRunner {
        return CommandLineRunner {
            LOG.info("Starting CommandLineRunner application")

            restTemplate.exchange(
                "http://localhost:8080/api/rooms",
                HttpMethod.GET,
                null,
                object : ParameterizedTypeReference<List<Room>>() {}
            ).body?.forEach { room ->
                LOG.info(room.toString())
            }

            LOG.info("Finishing CommandLineRunner application")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<RoomCommandLineRunnerApplication>(*args)
}
