package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.ProductDto
import com.k9.shopee.backend.repository.CategoryRepository
import com.k9.shopee.backend.repository.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {
    private fun getPageable(optionalLimit: Optional<Int>, optionalSort: Optional<String>): Pageable {
        val limit = if (optionalLimit.isPresent) optionalLimit.get() else this.productRepository.count().toInt()
        val direction = if (optionalSort.isPresent) if (optionalSort.get() == "asc"
        ) Sort.Direction.ASC else Sort.Direction.DESC else Sort.Direction.ASC
        return PageRequest.of(0, limit, direction, "id")
    }

    fun getAllProducts(limit: Optional<Int>, sort: Optional<String>): List<ProductDto> {
        val pageable = this.getPageable(limit, sort)
        return this.productRepository.findAll(pageable).map { product ->
            ProductDto(
                id = product.id,
                title = product.title,
                price = product.price,
                category = product.category?.title,
                description = product.description,
                image = product.image
            )
        }.content
    }
}