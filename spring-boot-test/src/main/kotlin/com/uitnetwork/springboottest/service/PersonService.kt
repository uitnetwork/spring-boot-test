package com.uitnetwork.springboottest.service

import com.uitnetwork.springboottest.model.Person
import org.springframework.stereotype.Service

@Service
class PersonService {
    fun getPerson(id: Long): Person {
        throw RuntimeException("Exception")
    }
}
