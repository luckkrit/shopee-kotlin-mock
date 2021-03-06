package com.k9.shopee.backend.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class CategoryRepositoryTest {
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Test
    fun `test category repository`() {
        val categories = categoryRepository.findAll()
        assertEquals(4, categories.size)
    }
}