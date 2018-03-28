package com.uitnetwork.springboottest

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = NONE)
class NoneTests {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Test
    fun contextLoads() {
        assertThatThrownBy { applicationContext.getBean(TestRestTemplate::class.java) }
                .isInstanceOf(NoSuchBeanDefinitionException::class.java)
        assertThatThrownBy { applicationContext.getBean(MockMvc::class.java) }
                .isInstanceOf(NoSuchBeanDefinitionException::class.java)
    }

}
