package com.k9.shopee.backend.dtos.user

data class AddressDto(
    val city: String? = null,
    val street: String? = null,
    val number: Long? = null,
    val zipcode: String? = null,
    val geolocationDto: GeolocationDto? = null
)
