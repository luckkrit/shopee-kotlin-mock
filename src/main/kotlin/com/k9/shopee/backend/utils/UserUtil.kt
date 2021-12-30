package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.user.AddUserDto
import com.k9.shopee.backend.dtos.user.UpdateUserDto
import com.k9.shopee.backend.dtos.user.UserDto
import com.k9.shopee.backend.models.Address
import com.k9.shopee.backend.models.User
import com.k9.shopee.backend.models.UserDetail

object UserUtil {
    fun getUserDto(user: User): UserDto {

        return UserDto(
            id = user.id,
            email = user.email,
            username = user.username,
            phone = user.userDetail?.phone,
            name = NameUtil.getNameDto(user.userDetail),
            address = AddressUtil.getAddressDto(
                user.address,
                GeolocationUtil.getGeolocationDto(user.address?.geolocation)
            )
        )
    }

    fun createUser(addUserDto: AddUserDto, address: Address, userDetail: UserDetail): User {
        val user = User()
        user.userDetail = userDetail
        user.address = address
        user.email = addUserDto.email
        user.password = addUserDto.password
        user.username = addUserDto.username
        return user
    }

    fun updateUser(user: User, updateUserDto: UpdateUserDto, address: Address, userDetail: UserDetail): User {
        user.userDetail = userDetail
        user.address = address
        user.email = updateUserDto.email
        user.username = updateUserDto.username
        user.password = updateUserDto.password
        return user
    }
}