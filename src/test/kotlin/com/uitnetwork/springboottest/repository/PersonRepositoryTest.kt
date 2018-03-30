package com.uitnetwork.springboottest.repository

import com.uitnetwork.springboottest.model.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class PersonRepositoryTest {
    companion object {
        const val TEST_NAME = "TEST_NAME"
        const val TEST_AGE = 123
    }

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Test
    fun findOneShouldWorkCorrectly() {
        val persistedPerson = testEntityManager.persist(Person(name = TEST_NAME, age = TEST_AGE))

        val personOptional = personRepository.findById(persistedPerson.id!!)

        assertThat(personOptional.isPresent).isTrue()
        assertThat(personOptional.get()).isEqualTo(persistedPerson)
    }
}
