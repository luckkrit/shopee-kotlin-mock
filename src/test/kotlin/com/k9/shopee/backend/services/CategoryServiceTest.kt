package com.k9.shopee.backend.services

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class CategoryServiceTest {
    @Autowired
    private lateinit var categoryService: CategoryService

    @Test
    fun deleteCategory() {
        val optionalCategory = categoryService.deleteCategory(1)
        assertEquals(true, optionalCategory.isPresent)
    }
}