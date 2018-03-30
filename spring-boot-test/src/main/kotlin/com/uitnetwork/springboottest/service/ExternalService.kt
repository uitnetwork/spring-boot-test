package com.uitnetwork.springboottest.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ExternalService(private val restTemplate: RestTemplate) {
    companion object {
        const val HARD_CODE_GOOGLE_URL = "https://google.com"
    }

    fun callExternal(input: String): String {
        val externalResult = restTemplate.getForObject(HARD_CODE_GOOGLE_URL, String::class.java)
        return "$externalResult $input"
    }
}
