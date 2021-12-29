package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.AddProductDto
import com.k9.shopee.backend.dtos.ProductDto
import com.k9.shopee.backend.dtos.UpdateProductDto
import com.k9.shopee.backend.models.Product
import com.k9.shopee.backend.repository.CategoryRepository
import com.k9.shopee.backend.repository.ProductRepository
import org.springframework.data.domain.Page
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

    fun getProduct(productId: Long): Optional<ProductDto> {
        val optionalProduct = this.productRepository.findById(productId)
        return if (optionalProduct.isPresent) {
            val product = optionalProduct.get()
            val productDto = ProductDto(id = product.id, title = product.title)
            Optional.of(productDto)
        } else {
            Optional.empty()
        }
    }

    fun getProductsByLimit(limit: Int): Page<ProductDto> =
        this.productRepository.findAll(this.getPageable(Optional.of(limit), Optional.of("asc"))).map { product ->
            ProductDto(
                id = product.id,
                title = product.title,
                price = product.price,
                category = product.category?.title,
                description = product.description,
                image = product.image
            )
        }

    fun toProductDto(product: Product): ProductDto = ProductDto(
        id = product.id,
        title = product.title,
        price = product.price,
        category = product.category?.title,
        description = product.description,
        image = product.image
    )

    fun addProduct(addProductDto: AddProductDto): Optional<ProductDto> {
        if (addProductDto.categoryId == null) return Optional.empty()
        val optionalCategory = this.categoryRepository.findById(addProductDto.categoryId)
        return if (optionalCategory.isPresent) {
            val product = Product()
            product.title = addProductDto.title
            product.category = optionalCategory.get()
            product.description = addProductDto.description
            product.price = addProductDto.price
            product.image = addProductDto.image
            val saveProduct = this.productRepository.save(product)
            val productDto = toProductDto(saveProduct)
            Optional.of(productDto)
        } else Optional.empty()
    }

    fun updateProduct(productId: Long, updateProductDto: UpdateProductDto): Optional<ProductDto> {
        if (updateProductDto.categoryId == null) return Optional.empty()
        val optionalCategory = this.categoryRepository.findById(updateProductDto.categoryId)
        val optionalProduct = this.productRepository.findById(productId)
        return if (optionalCategory.isPresent && optionalProduct.isPresent) {
            val product = optionalProduct.get()
            val saveProduct = this.productRepository.save(product)
            val productDto = toProductDto(saveProduct)
            Optional.of(productDto)
        } else Optional.empty()
    }

    fun deleteProduct(productId: Long): Optional<ProductDto> {
        val optionalProduct = this.productRepository.findById(productId)
        return if (optionalProduct.isPresent) {
            val product = optionalProduct.get()
            val productDto = toProductDto(product)
            this.productRepository.delete(product)
            Optional.of(productDto)
        } else Optional.empty()
    }
}