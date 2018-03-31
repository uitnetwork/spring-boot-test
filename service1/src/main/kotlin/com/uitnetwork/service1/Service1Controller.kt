package com.uitnetwork.service1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Service1Controller(private val service1Service: Service1Service) {

    @GetMapping("/service1/{id}")
    fun getService1(@PathVariable("id") id: Long): Service1 {
        return Service1(id, service1Service.randomString())
    }
}
