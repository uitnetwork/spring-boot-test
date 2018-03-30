package com.uitnetwork.springboottest

import com.uitnetwork.springboottest.controller.MessageController.Companion.TEST_MESSAGE
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
class DefinedPortTests {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Autowired
    private lateinit var testRestTemplate: TestRestTemplate

    @LocalServerPort
    private val localServerPort: Int = 0

    @Test
    fun contextLoads() {
        assertThat(localServerPort).isGreaterThan(0)
        Assertions.assertThatThrownBy { applicationContext.getBean(MockMvc::class.java) }
                .isInstanceOf(NoSuchBeanDefinitionException::class.java)
    }

    @Test
    fun testRestEnpoint() {
        val message = testRestTemplate.getForObject("/api/message", String::class.java)

        assertThat(message).isEqualTo(TEST_MESSAGE)
    }

}
