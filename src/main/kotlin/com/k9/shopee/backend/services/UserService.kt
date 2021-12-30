package com.k9.shopee.backend.services

import com.k9.shopee.backend.repository.AddressRepository
import com.k9.shopee.backend.repository.GeolocationRepository
import com.k9.shopee.backend.repository.UserDetailRepository
import com.k9.shopee.backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val geolocationRepository: GeolocationRepository,
    private val addressRepository: AddressRepository,
    private val userDetailRepository: UserDetailRepository
) {
//    fun getAllUsers(limit: Optional<Int>, sort: Optional<String>):List<UserDto> {
//    }
}