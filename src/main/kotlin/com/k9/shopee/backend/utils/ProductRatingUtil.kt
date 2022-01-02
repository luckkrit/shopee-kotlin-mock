package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.ProductRatingDto
import com.k9.shopee.backend.models.ProductRating

object ProductRatingUtil {
    fun createProductRating(productRatingDto: ProductRatingDto): ProductRating {
        val productRating = ProductRating()
        productRating.count = productRatingDto.count
        productRating.rate = productRatingDto.rate
        return productRating
    }

    fun getProductDto(productRating: ProductRating): ProductRatingDto =
        ProductRatingDto(rate = productRating.rate, count = productRating.count)
}