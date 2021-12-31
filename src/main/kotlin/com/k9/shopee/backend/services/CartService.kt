package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.CartDto
import com.k9.shopee.backend.repository.CartProductRepository
import com.k9.shopee.backend.repository.CartRepository
import com.k9.shopee.backend.repository.ProductRepository
import com.k9.shopee.backend.repository.UserRepository
import com.k9.shopee.backend.utils.CartUtil
import com.k9.shopee.backend.utils.PageableUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartService(
    private val cartRepository: CartRepository,
    private val cartProductRepository: CartProductRepository,
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository
) {
    fun getAllCarts(
        limit: Optional<Int>,
        sort: Optional<String>,
        startDate: Optional<Date>,
        endDate: Optional<Date>
    ): List<CartDto> {
        val pageable = PageableUtil.getPageable(limit, sort, cartRepository.count().toInt())
        return if (startDate.isPresent && endDate.isPresent) {
            val carts = cartRepository.findAllByDateBetween(pageable, startDate.get(), endDate.get()).content
            CartUtil.getListCartDto(carts)
        } else if (startDate.isPresent) {
            val carts = cartRepository.findAllByDateGreaterThanEqual(pageable, startDate.get()).content
            CartUtil.getListCartDto(carts)
        } else if (endDate.isPresent) {
            val carts = cartRepository.findAllByDateLessThanEqual(pageable, endDate.get()).content
            CartUtil.getListCartDto(carts)
        } else {
            val carts = cartRepository.findAll(pageable).content
            CartUtil.getListCartDto(carts)
        }
    }

    fun getCart(cartId: Long): Optional<CartDto> {
        val optionalCart = cartRepository.findById(cartId)
        return if (optionalCart.isPresent) Optional.of(CartUtil.getCartDto(optionalCart.get())) else Optional.empty()
    }

    fun getAllCartsByUser(userId: Long): List<CartDto> {
        val carts = cartRepository.findByUserId(userId)
        return CartUtil.getListCartDto(carts)
    }
}