package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.CartDto
import com.k9.shopee.backend.models.Cart
import com.k9.shopee.backend.models.User

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

    fun createCart(cartDto: CartDto, user: User): Cart {
        val cart = Cart()
        cart.date = cartDto.date
        cart.user = user
        return cart
    }

    fun updateCart(cart: Cart, cartDto: CartDto, user: User): Cart {
        cart.date = cartDto.date
        cart.user = user
        return cart
    }
}