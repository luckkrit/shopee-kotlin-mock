package com.k9.shopee.backend.controllers

import com.k9.shopee.backend.dtos.category.AddCategoryDto
import com.k9.shopee.backend.dtos.category.CategoryDto
import com.k9.shopee.backend.dtos.category.UpdateCategoryDto
import com.k9.shopee.backend.services.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
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

    @PostMapping
    fun postCategory(@RequestBody addCategoryDto: AddCategoryDto): ResponseEntity<Any> {
        val optionalCategory = this.categoryService.addCategory(addCategoryDto)
        return if (optionalCategory.isPresent) ResponseEntity.created(URI.create("/category/${optionalCategory.get().id}"))
            .build() else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun putCategory(@PathVariable id: Long, updateCategoryDto: UpdateCategoryDto): ResponseEntity<Any> {
        val optionalCategory = this.categoryService.updateCategory(id, updateCategoryDto)
        return if (optionalCategory.isPresent) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun patchCategory(@PathVariable id: Long, updateCategoryDto: UpdateCategoryDto): ResponseEntity<Any> {
        val optionalCategory = this.categoryService.updateCategory(id, updateCategoryDto)
        return if (optionalCategory.isPresent) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): ResponseEntity<CategoryDto> {
        val optionalCategory = this.categoryService.deleteCategory(id)
        return if (optionalCategory.isPresent) ResponseEntity.ok(optionalCategory.get()) else ResponseEntity.notFound()
            .build()
    }
}