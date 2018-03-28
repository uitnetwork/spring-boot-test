package com.uitnetwork.springboottest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/message")
class MessageController {
    companion object {
        const val TEST_MESSAGE = "TEST_MESSAGE"
    }

    @GetMapping
    fun getMessage(): String {
        return TEST_MESSAGE
    }
}
