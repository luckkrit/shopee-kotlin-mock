package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.CartProductDto
import com.k9.shopee.backend.models.CartProduct

object CartProductUtil {
    private fun getCartProductDto(cartProduct: CartProduct): CartProductDto =
        CartProductDto(productId = cartProduct.product?.id, quantity = cartProduct.quantity)

    fun getListCartProductDto(cartProducts: List<CartProduct>): List<CartProductDto> =
        cartProducts.map(CartProductUtil::getCartProductDto)
}