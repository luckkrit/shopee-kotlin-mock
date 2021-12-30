package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.category.AddCategoryDto
import com.k9.shopee.backend.dtos.category.CategoryDto
import com.k9.shopee.backend.dtos.category.UpdateCategoryDto
import com.k9.shopee.backend.exceptions.ProductExistsException
import com.k9.shopee.backend.models.Category
import com.k9.shopee.backend.models.Product
import com.k9.shopee.backend.repository.CategoryRepository
import com.k9.shopee.backend.utils.CategoryUtil
import com.k9.shopee.backend.utils.PageableUtil
import org.hibernate.Hibernate
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class CategoryService(val categoryRepository: CategoryRepository) {

    fun getCategory(categoryId: Long): Optional<CategoryDto> =
        this.categoryRepository.findById(categoryId).map(CategoryUtil::getCategoryDto)

    fun getAllCategories(limit: Optional<Int>, sort: Optional<String>): List<CategoryDto> {
        val pageable = PageableUtil.getPageable(limit, sort, categoryRepository.count().toInt())
        return this.categoryRepository.findAll(pageable)
            .map(CategoryUtil::getCategoryDto).content
    }

    fun addCategory(addCategoryDto: AddCategoryDto): Optional<CategoryDto> {
        val saveCategory = categoryRepository.save(CategoryUtil.createCategory(addCategoryDto))
        return Optional.of(CategoryUtil.getCategoryDto(saveCategory))
    }

    fun updateCategory(categoryId: Long, updateCategoryDto: UpdateCategoryDto): Optional<CategoryDto> {
        val optionalCategory = categoryRepository.findById(categoryId)
        return if (optionalCategory.isPresent) {
            val saveCategory =
                categoryRepository.save(CategoryUtil.updateCategory(optionalCategory.get(), updateCategoryDto))
            Optional.of(CategoryUtil.getCategoryDto(saveCategory))
        } else {
            Optional.empty()
        }

    }

    fun deleteCategory(categoryId: Long): Optional<CategoryDto> {
        val optionalCategory = categoryRepository.findById(categoryId)
        return if (optionalCategory.isPresent) {
            val category = optionalCategory.get()
            if (this.getProductCategory(category).isEmpty()
                    .not()
            ) throw ProductExistsException("There are some products relate to this category")
            categoryRepository.delete(category)
            Optional.of(CategoryUtil.getCategoryDto(category))
        } else Optional.empty()
    }

    fun getProductCategory(category: Category): List<Product> {
        if (Hibernate.isInitialized(category.products).not()) Hibernate.initialize(category.products)
        return category.products
    }
}