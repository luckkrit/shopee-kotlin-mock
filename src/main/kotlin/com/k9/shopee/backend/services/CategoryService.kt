package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.CategoryDto
import com.k9.shopee.backend.models.Category
import com.k9.shopee.backend.repository.CategoryRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class CategoryService(val categoryRepository: CategoryRepository) {

    private fun getCategoryDto(category: Category): CategoryDto = CategoryDto(category.id, category.title)
    fun getCategory(categoryId: Long): Optional<CategoryDto> =
        this.categoryRepository.findById(categoryId).map(this::getCategoryDto)

    fun getAllCategories(): List<CategoryDto> =
        this.categoryRepository.findAll().stream().map(this::getCategoryDto).collect(
            Collectors.toList()
        )
}