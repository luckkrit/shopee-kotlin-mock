package com.k9.shopee.backend.dtos

import java.io.Serializable

data class CartProductDto(val productId: Long? = null, val quantity: Long? = null) : Serializable
