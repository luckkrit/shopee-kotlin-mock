package com.k9.shopee.backend.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    fun `test product repository`() {
        val products = productRepository.findAll()
        assertEquals(20, products.size)
    }
}