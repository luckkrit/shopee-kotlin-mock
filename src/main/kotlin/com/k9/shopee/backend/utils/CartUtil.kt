package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.CartDto
import com.k9.shopee.backend.models.Cart

object CartUtil {
    fun getListCartDto(carts: List<Cart>): List<CartDto> {
        return carts.map(CartUtil::getCartDto)
    }

    fun getCartDto(cart: Cart): CartDto {
        return CartDto(
            date = cart.date,
            id = cart.id,
            cartProducts = CartProductUtil.getListCartProductDto(cart.cartProducts),
            userId = cart.user?.id
        )
    }
}