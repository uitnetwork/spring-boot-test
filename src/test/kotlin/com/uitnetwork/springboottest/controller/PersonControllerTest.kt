package com.uitnetwork.springboottest.controller

import com.nhaarman.mockito_kotlin.whenever
import com.uitnetwork.springboottest.model.Person
import com.uitnetwork.springboottest.service.PersonService
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebMvcTest(PersonController::class)
class PersonControllerTest {
    companion object {
        const val TEST_ID = 1L
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var personService: PersonService

    private val person = Person(1L, "test", 33)

    @Before
    fun setup() {
        whenever(personService.getPerson(TEST_ID)).thenReturn(person)
    }

    @Test
    fun restReturnCorrectly() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/$TEST_ID"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.`is`(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.`is`("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age", Matchers.`is`(33)))
    }

}
