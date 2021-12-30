package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.category.AddCategoryDto
import com.k9.shopee.backend.dtos.category.CategoryDto
import com.k9.shopee.backend.dtos.category.UpdateCategoryDto
import com.k9.shopee.backend.models.Category

object CategoryUtil {
    fun getCategoryDto(category: Category): CategoryDto = CategoryDto(category.id, category.title)
    fun createCategory(addCategoryDto: AddCategoryDto): Category {
        val category = Category()
        category.title = addCategoryDto.title
        return category
    }

    fun updateCategory(category: Category, updateCategoryDto: UpdateCategoryDto): Category {
        category.title = updateCategoryDto.title
        return category
    }
}