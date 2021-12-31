package com.k9.shopee.backend.services

import com.k9.shopee.backend.dtos.user.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class UserServiceTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    @Order(1)
    fun getAllUsers() {
        val users = userService.getAllUsers(Optional.empty(), Optional.empty())
        assertEquals(10, users.size)
    }

    @Test
    @Order(2)
    fun getUser() {
        val optionalUser = userService.getUser(1)
        assertEquals(true, optionalUser.isPresent)
    }

    @Test
    @Order(3)
    fun addUser() {
        val addUserDto = AddUserDto(
            email = "1",
            username = "2",
            password = "3",
            name = NameDto(firstname = "4", lastname = "5"),
            phone = "6",
            address = AddressDto(
                city = "7",
                street = "8",
                number = 9,
                zipcode = "10",
                geolocationDto = GeolocationDto(latitude = 11F, longitude = 12F)
            )
        )
        val optionalUser = userService.addUser(addUserDto)
        assertEquals(true, optionalUser.isPresent)
    }

    @Test
    @Order(4)
    fun updateUser() {
        val updateUserDto = UpdateUserDto(
            email = "11",
            username = "22",
            password = "33",
            name = NameDto(firstname = "44", lastname = "55"),
            phone = null,
            address = AddressDto(
                city = "7",
                street = "8",
                number = 9,
                zipcode = "10",
                geolocationDto = GeolocationDto(latitude = 11F, longitude = 12F)
            )
        )
        val optionalUser = userService.updateUser(11, updateUserDto)
        assertEquals(true, optionalUser.isPresent)
        assertEquals(null, optionalUser.get().phone)
    }

    @Test
    @Order(5)
    fun deleteUser() {
        val optionalUser = userService.deleteUser(11)
        assertEquals(true, optionalUser.isPresent)
        val totalUsers = userService.getAllUsers(Optional.empty(), Optional.empty())
        assertEquals(10, totalUsers.size)
    }
}