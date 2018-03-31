package com.uitnetwork.springboottest

import org.assertj.core.api.Assertions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = NONE)
class ContractTest {
    @get:Rule
    val stubRunnerRule = StubRunnerRule()
            .downloadStub("com.uitnetwork", "service1", "0.0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.CLASSPATH)

    @Test
    fun test() {
        val restTemplate = RestTemplate()

        val entity = restTemplate.getForEntity("http://localhost:8100/service1/1", Service1::class.java)

        Assertions.assertThat(entity.statusCode.value()).isEqualTo(200)
        Assertions.assertThat(entity.body!!.id).isEqualTo(1)
        Assertions.assertThat(entity.body!!.name).isEqualTo("something")
    }

}

data class Service1(
        val id: Long,
        val name: String
)
