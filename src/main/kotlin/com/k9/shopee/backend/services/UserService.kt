package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.user.AddUserDto
import com.k9.shopee.backend.dtos.user.UpdateUserDto
import com.k9.shopee.backend.dtos.user.UserDto
import com.k9.shopee.backend.repository.AddressRepository
import com.k9.shopee.backend.repository.GeolocationRepository
import com.k9.shopee.backend.repository.UserDetailRepository
import com.k9.shopee.backend.repository.UserRepository
import com.k9.shopee.backend.utils.*
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val geolocationRepository: GeolocationRepository,
    private val addressRepository: AddressRepository,
    private val userDetailRepository: UserDetailRepository
) {
    fun getAllUsers(limit: Optional<Int>, sort: Optional<String>): List<UserDto> {
        return userRepository.findAll(
            PageableUtil.getPageable(
                limit,
                sort,
                userRepository.count().toInt()
            )
        ).content.map { user -> UserUtil.getUserDto(user) }
    }

    fun getUser(userId: Long): Optional<UserDto> {
        val optionalUser = userRepository.findById(userId)
        return if (optionalUser.isPresent) Optional.of(UserUtil.getUserDto(optionalUser.get())) else Optional.empty()
    }

    fun addUser(addUserDto: AddUserDto): Optional<UserDto> {
        if (addUserDto.address == null || addUserDto.name == null) return Optional.empty()
        val addressDto = addUserDto.address
        val geolocationDto = addressDto.geolocationDto ?: return Optional.empty()
        val nameDto = addUserDto.name
        val saveGeolocation = geolocationRepository.save(GeolocationUtil.createGeolocation(geolocationDto))
        val saveAddress = addressRepository.save(AddressUtil.createAddress(addressDto, saveGeolocation))
        val saveUserDetail = userDetailRepository.save(UserDetailUtil.createUserDetail(nameDto, addUserDto.phone))
        val saveUser = userRepository.save(UserUtil.createUser(addUserDto, saveAddress, saveUserDetail))
        return Optional.of(UserUtil.getUserDto(saveUser))
    }

    fun updateUser(userId: Long, updateUserDto: UpdateUserDto): Optional<UserDto> {
        if (updateUserDto.address == null || updateUserDto.name == null) return Optional.empty()
        val addressDto = updateUserDto.address
        val geolocationDto = addressDto.geolocationDto ?: return Optional.empty()
        val nameDto = updateUserDto.name
        val optionalUser = userRepository.findById(userId)
        if (optionalUser.isEmpty) return Optional.empty()
        val user = optionalUser.get()
        var address = user.address
        var geolocation = user.address?.geolocation
        geolocation = if (geolocation == null) {
            geolocationRepository.save(GeolocationUtil.createGeolocation(geolocationDto))
        } else {
            geolocationRepository.save(GeolocationUtil.updateGeolocation(geolocation, geolocationDto))
        }
        address = if (address == null) {
            addressRepository.save(AddressUtil.createAddress(addressDto, geolocation))
        } else {

            addressRepository.save(AddressUtil.updateAddress(address, addressDto, geolocation))
        }
        var userDetail = user.userDetail
        userDetail = if (userDetail == null) {
            userDetailRepository.save(UserDetailUtil.createUserDetail(nameDto, updateUserDto.phone))
        } else {
            userDetailRepository.save(UserDetailUtil.updateUserDetail(userDetail, nameDto, updateUserDto.phone))
        }
        return Optional.of(
            UserUtil.getUserDto(
                userRepository.save(
                    UserUtil.updateUser(
                        user,
                        updateUserDto,
                        address,
                        userDetail
                    )
                )
            )
        )

    }

    fun deleteUser(userId: Long): Optional<UserDto> {
        val optionalUser = userRepository.findById(userId)
        return if (optionalUser.isPresent) {
            val user = optionalUser.get()
            if (user.address != null) {
                if (user.address?.geolocation != null) {
                    this.geolocationRepository.delete(user.address?.geolocation!!)
                }
                this.addressRepository.delete(user.address!!)
            }
            if (user.userDetail != null) {
                this.userDetailRepository.delete(user.userDetail!!)
            }
            this.userRepository.delete(user)
            Optional.of(UserUtil.getUserDto(user))
        } else {
            Optional.empty()
        }
    }
}