package com.uitnetwork.service1;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(MockitoJUnitRunner.class)
public abstract class MvcTest2 {

    @Mock
    private Service1Service service1Service;

    @Before
    public void setup() {
        when(service1Service.randomString()).thenReturn("something");

        RestAssuredMockMvc.standaloneSetup(new Service1Controller(service1Service));
    }
}
