package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.ProductRatingDto
import com.k9.shopee.backend.repository.ProductRatingRepository
import com.k9.shopee.backend.repository.ProductRepository
import com.k9.shopee.backend.utils.ProductRatingUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductRatingService(
    private val productRepository: ProductRepository,
    private val productRatingRepository: ProductRatingRepository
) {
    fun addProductRating(productId: Long, productRatingDto: ProductRatingDto): Optional<ProductRatingDto> {
        val optionalProduct = productRepository.findById(productId)
        return if (optionalProduct.isPresent) {
            val saveProductRating =
                productRatingRepository.save(ProductRatingUtil.createProductRating(productRatingDto))
            val product = optionalProduct.get()
            product.productRating = saveProductRating
            productRepository.save(product)
            Optional.of(productRatingDto)
        } else {
            Optional.empty()
        }
    }

    fun updateProductRating(productId: Long, productRatingDto: ProductRatingDto): Optional<ProductRatingDto> {
        val optionalProduct = productRepository.findById(productId)
        return if (optionalProduct.isPresent) {
            val product = optionalProduct.get()
            var productRating = product.productRating
            productRating = if (productRating != null) {
                ProductRatingUtil.updateProductRating(productRating, productRatingDto)
            } else {
                ProductRatingUtil.createProductRating(productRatingDto)
            }
            productRatingRepository.save(productRating)
            Optional.of(productRatingDto)
        } else {
            Optional.empty()
        }
    }
}