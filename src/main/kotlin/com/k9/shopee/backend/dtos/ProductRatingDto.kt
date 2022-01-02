package com.k9.shopee.backend.dtos

import java.io.Serializable

data class ProductRatingDto(val rate: Float? = null, val count: Long? = null) : Serializable
