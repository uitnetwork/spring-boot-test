package com.uitnetwork.springboottest.model


import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.util.StreamUtils.copyToString
import java.nio.charset.Charset.defaultCharset

@RunWith(SpringRunner::class)
@JsonTest
class PersonTest {
    companion object {
        const val TEST_PERSON_JSON = "/test_person.json"
    }

    @Autowired
    private lateinit var personJacksonTester: JacksonTester<Person>

    private val testPerson = Person(1L, "some name", 22)

    private val testPersonJson: String by lazy {
        copyToString(this.javaClass.getResourceAsStream(TEST_PERSON_JSON), defaultCharset())
    }

    @Test
    fun serializeJsonCorrectly() {
        assertThat(personJacksonTester.write(testPerson)).isEqualTo(TEST_PERSON_JSON)
        assertThat(personJacksonTester.write(testPerson)).isEqualToJson(TEST_PERSON_JSON)
    }

    @Test
    fun deserializeJsonCorrectly() {
        val person = personJacksonTester.readObject(TEST_PERSON_JSON)

        assertThat(person).isEqualTo(testPerson)
    }
}
