package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.CartProductDto
import com.k9.shopee.backend.models.Cart
import com.k9.shopee.backend.models.CartProduct
import com.k9.shopee.backend.models.Product

object CartProductUtil {
    private fun getCartProductDto(cartProduct: CartProduct): CartProductDto =
        CartProductDto(productId = cartProduct.product?.id, quantity = cartProduct.quantity)

    fun getListCartProductDto(cartProducts: List<CartProduct>): List<CartProductDto> =
        cartProducts.map(CartProductUtil::getCartProductDto)

    fun createCartProduct(cart: Cart, product: Product, cartProductDto: CartProductDto): CartProduct {
        val cartProduct = CartProduct()
        cartProduct.cart = cart
        cartProduct.product = product
        cartProduct.quantity = cartProductDto.quantity
        return cartProduct
    }
}