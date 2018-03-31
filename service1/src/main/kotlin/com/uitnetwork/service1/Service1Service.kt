package com.uitnetwork.service1

import org.springframework.stereotype.Service
import java.util.*

@Service
class Service1Service {
    fun randomString(): String {
        return UUID.randomUUID().toString()
    }
}
