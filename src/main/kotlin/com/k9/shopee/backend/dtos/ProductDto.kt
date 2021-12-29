package com.k9.shopee.backend.dtos

import java.io.Serializable

data class ProductDto(
    val id: Long? = null,
    val category: String? = null,
    val description: String? = null,
    val title: String? = null,
    val price: Float? = null,
    val image: String? = null
) : Serializable
