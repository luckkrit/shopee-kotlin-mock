package com.k9.shopee.backend.dtos.user

data class UserDto(
    val id: Long? = null,
    val email: String? = null,
    val username: String? = null,
    val password: String? = null,
    val name: NameDto? = null,
    val address: AddressDto? = null,
    val phone: String? = null
)
