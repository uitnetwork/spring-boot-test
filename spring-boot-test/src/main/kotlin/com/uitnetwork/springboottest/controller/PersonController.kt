package com.uitnetwork.springboottest.controller

import com.uitnetwork.springboottest.model.Person
import com.uitnetwork.springboottest.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person")
class PersonController(private val personService: PersonService) {

    @GetMapping("/{id}")
    fun getPerson(@PathVariable("id") id: Long): Person {
        return personService.getPerson(id)
    }

}
