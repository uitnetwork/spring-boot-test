package com.uitnetwork.springboottest

import com.uitnetwork.springboottest.controller.MessageController.Companion.TEST_MESSAGE
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc(secure = false)
class MockTests {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        assertThatThrownBy { applicationContext.getBean(TestRestTemplate::class.java) }
                .isInstanceOf(NoSuchBeanDefinitionException::class.java)
    }

    @Test
    fun testRestEnpoint() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/message"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string(TEST_MESSAGE))
    }
}
