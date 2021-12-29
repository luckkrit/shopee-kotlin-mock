package com.k9.shopee.backend.controllers

import com.k9.shopee.backend.dtos.CategoryDto
import com.k9.shopee.backend.services.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products/categories")
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping
    fun getAllCategories(): ResponseEntity<List<CategoryDto>> = ResponseEntity.ok(categoryService.getAllCategories())

    @GetMapping("/{id}")
    fun getCategory(@PathVariable id: Long): ResponseEntity<CategoryDto> {
        val optionalCategory = this.categoryService.getCategory(id)
        return if (optionalCategory.isPresent) {
            ResponseEntity.ok(optionalCategory.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}