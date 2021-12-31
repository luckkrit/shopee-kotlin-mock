package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.category.AddCategoryDto
import com.k9.shopee.backend.dtos.category.UpdateCategoryDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class CategoryServiceTest {
    @Autowired
    private lateinit var categoryService: CategoryService


    @Test
    @Order(5)
    fun deleteCategory() {
        val optionalCategory = categoryService.deleteCategory(5)
        assertEquals(true, optionalCategory.isPresent)
    }

    @Test
    @Order(2)
    fun getCategory() {
        val optionalCategory = categoryService.getCategory(1)
        assertEquals(true, optionalCategory.isPresent)
    }

    @Test
    @Order(1)
    fun getAllCategories() {
        val categories = categoryService.getAllCategories(Optional.empty(), Optional.empty())
        assertEquals(true, categories.isNotEmpty())
    }

    @Test
    @Order(3)
    fun addCategory() {
        val optionalCategory = categoryService.addCategory(AddCategoryDto(title = "test"))
        assertEquals(true, optionalCategory.isPresent)
        assertEquals(5, optionalCategory.get().id)
    }

    @Test
    @Order(4)
    fun updateCategory() {
        val optionalCategory = categoryService.updateCategory(5, UpdateCategoryDto(title = "test2"))
        assertEquals("test2", optionalCategory.get().title)
    }
}