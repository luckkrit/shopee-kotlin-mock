package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.AddProductDto
import com.k9.shopee.backend.dtos.ProductDto
import com.k9.shopee.backend.dtos.UpdateProductDto
import com.k9.shopee.backend.models.Category
import com.k9.shopee.backend.models.Product

object EntityUtil {
    fun getProductDto(product: Product): ProductDto = ProductDto(
        id = product.id,
        category = product.category?.title,
        description = product.description,
        title = product.title,
        price = product.price,
        image = product.image
    )

    fun createProduct(addProductDto: AddProductDto, category: Category): Product {
        val product = Product()
        product.description = addProductDto.description
        product.category = category
        product.image = addProductDto.image
        product.price = addProductDto.price
        return product
    }

    fun updateProduct(product: Product, updateProductDto: UpdateProductDto, category: Category): Product {
        product.price = updateProductDto.price
        product.image = updateProductDto.image
        product.description = updateProductDto.description
        product.category = category
        return product
    }
}