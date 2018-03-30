package com.uitnetwork.springboottest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.uitnetwork.springboottest.repository"])
class SpringBootTestApplication

fun main(args: Array<String>) {
    runApplication<SpringBootTestApplication>(*args)
}
