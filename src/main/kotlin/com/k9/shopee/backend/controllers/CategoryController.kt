package com.k9.shopee.backend.controllers

import com.k9.shopee.backend.dtos.category.CategoryDto
import com.k9.shopee.backend.services.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/products/categories")
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping
    fun getAllCategories(): ResponseEntity<List<CategoryDto>> = ResponseEntity.ok(
        categoryService.getAllCategories(
            Optional.empty(), Optional.empty()
        )
    )

    @GetMapping("/{id}")
    fun getCategory(@PathVariable id: Long): ResponseEntity<CategoryDto> {
        val optionalCategory = this.categoryService.getCategory(id)
        return if (optionalCategory.isPresent) {
            ResponseEntity.ok(optionalCategory.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): ResponseEntity<CategoryDto> {
        val optionalCategory = this.categoryService.deleteCategory(id)
        return if (optionalCategory.isPresent) ResponseEntity.ok(optionalCategory.get()) else ResponseEntity.notFound()
            .build()
    }
}