package com.uitnetwork.springboottest.repository

import com.uitnetwork.springboottest.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long>
