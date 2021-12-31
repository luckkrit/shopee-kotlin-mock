package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.CartProductDto
import com.k9.shopee.backend.models.Cart
import com.k9.shopee.backend.models.CartProduct
import com.k9.shopee.backend.repository.CartProductRepository
import com.k9.shopee.backend.repository.ProductRepository
import com.k9.shopee.backend.utils.CartProductUtil
import org.springframework.stereotype.Service

@Service
class CartProductService(
    private val cartProductRepository: CartProductRepository,
    private val productRepository: ProductRepository
) {
    fun addCartProduct(cartProductDto: CartProductDto, cart: Cart) {

        val productId = cartProductDto.productId
        if (productId != null) {
            val optionalProduct = productRepository.findById(cartProductDto.productId)
            if (optionalProduct.isPresent) {
                cartProductRepository.save(
                    CartProductUtil.createCartProduct(
                        cart,
                        optionalProduct.get(),
                        cartProductDto
                    )
                )
            }
        }
    }

    fun deleteCartProduct(cartProduct: CartProduct) {
        cartProductRepository.delete(cartProduct)
    }
}