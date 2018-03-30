package com.uitnetwork.springboottest.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "PERSON")
data class Person(
        @Id
        @GeneratedValue
        var id: Long? = null,
        val name: String,
        val age: Int
)
