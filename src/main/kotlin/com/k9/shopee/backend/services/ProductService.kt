package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.AddProductDto
import com.k9.shopee.backend.dtos.ProductDto
import com.k9.shopee.backend.dtos.UpdateProductDto
import com.k9.shopee.backend.repository.CategoryRepository
import com.k9.shopee.backend.repository.ProductRepository
import com.k9.shopee.backend.utils.PageableUtil
import com.k9.shopee.backend.utils.ProductUtil
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {

    fun getAllProducts(limit: Optional<Int>, sort: Optional<String>): List<ProductDto> {
        val pageable = PageableUtil.getPageable(limit, sort, productRepository.count().toInt())
        return this.productRepository.findAll(pageable).map(ProductUtil::getProductDto).content
    }

    fun getProduct(productId: Long): Optional<ProductDto> =
        this.productRepository.findById(productId).map(ProductUtil::getProductDto)

    fun getProductsByLimit(limit: Int): Page<ProductDto> =
        this.productRepository.findAll(
            PageableUtil.getPageable(
                Optional.of(limit),
                Optional.of("asc"),
                productRepository.count().toInt()
            )
        )
            .map(ProductUtil::getProductDto)


    fun addProduct(addProductDto: AddProductDto): Optional<ProductDto> {
        if (addProductDto.categoryId == null) return Optional.empty()
        val optionalCategory = this.categoryRepository.findById(addProductDto.categoryId)
        return if (optionalCategory.isPresent) {
            val product = ProductUtil.createProduct(addProductDto, optionalCategory.get())
            val saveProduct = this.productRepository.save(product)
            val productDto = ProductUtil.getProductDto(saveProduct)
            Optional.of(productDto)
        } else Optional.empty()
    }

    fun updateProduct(productId: Long, updateProductDto: UpdateProductDto): Optional<ProductDto> {
        if (updateProductDto.categoryId == null) return Optional.empty()
        val optionalCategory = this.categoryRepository.findById(updateProductDto.categoryId)
        val optionalProduct = this.productRepository.findById(productId)
        return if (optionalCategory.isPresent && optionalProduct.isPresent) {
            val product = ProductUtil.updateProduct(optionalProduct.get(), updateProductDto, optionalCategory.get())
            val saveProduct = this.productRepository.save(product)
            val productDto = ProductUtil.getProductDto(saveProduct)
            Optional.of(productDto)
        } else Optional.empty()
    }

    fun deleteProduct(productId: Long): Optional<ProductDto> {
        val optionalProduct = this.productRepository.findById(productId)
        return if (optionalProduct.isPresent) {
            val product = optionalProduct.get()
            val productDto = ProductUtil.getProductDto(product)
            this.productRepository.delete(product)
            Optional.of(productDto)
        } else Optional.empty()
    }
}