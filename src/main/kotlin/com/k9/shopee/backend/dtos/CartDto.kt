package com.k9.shopee.backend.dtos

import java.io.Serializable
import java.util.*

data class CartDto(
    val id: Long? = null,
    val date: Date? = null,
    val cartProducts: List<CartProductDto>? = null,
    val userId: Long?
) :
    Serializable
