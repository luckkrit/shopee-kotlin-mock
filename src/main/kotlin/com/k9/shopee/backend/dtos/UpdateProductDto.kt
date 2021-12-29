package com.k9.shopee.backend.dtos

import java.io.Serializable

data class UpdateProductDto(
    val id: Long? = null,
    val categoryId: Long? = null,
    val description: String? = null,
    val title: String? = null,
    val price: Float? = null,
    val image: String? = null
) : Serializable
