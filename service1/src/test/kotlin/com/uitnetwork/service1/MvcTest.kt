package com.uitnetwork.service1

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
abstract class MvcTest {

    @Mock
    private lateinit var service1Service: Service1Service

    @Before
    fun setup() {
        Mockito.`when`(service1Service.randomString()).thenReturn("something")
        RestAssuredMockMvc.standaloneSetup(Service1Controller(service1Service))
    }
}
