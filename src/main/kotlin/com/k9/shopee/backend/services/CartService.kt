package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.CartDto
import com.k9.shopee.backend.models.User
import com.k9.shopee.backend.repository.CartRepository
import com.k9.shopee.backend.repository.UserRepository
import com.k9.shopee.backend.utils.CartUtil
import com.k9.shopee.backend.utils.PageableUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartService(
    private val cartRepository: CartRepository,
    private val userRepository: UserRepository,
    private val cartProductService: CartProductService
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

    fun addCart(cartDto: CartDto): Optional<CartDto> {
        val userId = cartDto.userId ?: return Optional.empty<CartDto>()
        val optionalUser = userRepository.findById(userId)
        return if (optionalUser.isPresent) {
            val saveCart = cartRepository.save(CartUtil.createCart(cartDto, optionalUser.get()))
            val createCartDto = CartUtil.getCartDto(saveCart)
            cartDto.cartProducts?.forEach { cartProductDto ->
                cartProductService.addCartProduct(cartProductDto, saveCart)
            }
            Optional.of(createCartDto)
        } else {
            Optional.empty()
        }
    }

    fun updateCart(cartId: Long, cartDto: CartDto): Optional<CartDto> {
        val optionalCart = cartRepository.findById(cartId)
        val userId = cartDto.userId
        var optionalUser: Optional<User> = Optional.empty()
        if (userId != null) optionalUser = userRepository.findById(userId)
        return if (optionalUser.isPresent && optionalCart.isPresent) {
            val cart = optionalCart.get()
            val saveCart = cartRepository.save(CartUtil.updateCart(cart, cartDto, optionalUser.get()))
            // delete child table
            val oldCartProducts = cart.cartProducts
            oldCartProducts.forEach(cartProductService::deleteCartProduct)
            val updateCartDto = CartUtil.getCartDto(saveCart)
            cartDto.cartProducts?.forEach { cartProductDto ->
                cartProductService.addCartProduct(cartProductDto, saveCart)
            }
            Optional.of(updateCartDto)
        } else {
            Optional.empty()
        }
    }

    fun deleteCart(cartId: Long): Optional<CartDto> {
        val optionalCart = cartRepository.findById(cartId)
        return if (optionalCart.isPresent) {
            val cartProducts = optionalCart.get().cartProducts
            // delete child table
            cartProducts.forEach(cartProductService::deleteCartProduct)
            cartRepository.delete(optionalCart.get())
            Optional.of(CartUtil.getCartDto(optionalCart.get()))
        } else {
            Optional.empty()
        }
    }
}