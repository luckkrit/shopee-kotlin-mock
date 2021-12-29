package com.k9.shopee.backend.controllers

import com.k9.shopee.backend.dtos.CategoryDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class CategoryControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun getAllCategories() {
        var result = restTemplate.getForEntity<List<CategoryDto>>("/products/categories")
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.size, 4)
    }

    @Test
    fun getCategory() {
        var result = restTemplate.getForEntity<CategoryDto>("/products/categories/1")
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        val categoryDto = result.body
        assertNotNull(categoryDto)
        assertEquals(categoryDto?.id, 1)
    }
}