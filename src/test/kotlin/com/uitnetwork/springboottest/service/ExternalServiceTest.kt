package com.uitnetwork.springboottest.service

import com.uitnetwork.springboottest.service.ExternalService.Companion.HARD_CODE_GOOGLE_URL
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers.method
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

@RunWith(SpringRunner::class)
@RestClientTest(ExternalService::class)
@AutoConfigureWebClient(registerRestTemplate = true)
class ExternalServiceTest {
    companion object {
        const val TEST_EXTERNAL_RESULT = "TEST_EXTERNAL_RESULT"
        const val TEST_INPUT = "TEST_INPUT"
    }

    @Autowired
    private lateinit var externalService: ExternalService

    @Autowired
    private lateinit var mockRestServiceServer: MockRestServiceServer

    @Test
    fun `callExternal method() should return result based on the external data`() {
        mockRestServiceServer
                .expect(requestTo(HARD_CODE_GOOGLE_URL))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(TEST_EXTERNAL_RESULT, APPLICATION_JSON))

        val result = externalService.callExternal(TEST_INPUT)

        assertThat(result).isEqualTo("$TEST_EXTERNAL_RESULT $TEST_INPUT")
        mockRestServiceServer.verify()
    }
}
