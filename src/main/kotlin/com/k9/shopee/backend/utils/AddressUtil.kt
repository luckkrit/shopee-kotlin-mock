package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.user.AddressDto
import com.k9.shopee.backend.dtos.user.GeolocationDto
import com.k9.shopee.backend.models.Address
import com.k9.shopee.backend.models.Geolocation

object AddressUtil {
    fun createAddress(addressDto: AddressDto, geolocation: Geolocation): Address {
        val address = Address()
        address.geolocation = geolocation
        address.city = addressDto.city
        address.number = addressDto.number
        address.street = addressDto.street
        address.zipcode = addressDto.zipcode
        return address
    }

    fun updateAddress(address: Address, addressDto: AddressDto, geolocation: Geolocation): Address {
        address.geolocation = geolocation
        address.zipcode = addressDto.zipcode
        address.number = addressDto.number
        address.city = addressDto.city
        address.street = addressDto.street
        return address
    }

    fun getAddressDto(address: Address?, geolocationDto: GeolocationDto): AddressDto = AddressDto(
        city = address?.city,
        street = address?.street,
        number = address?.number,
        zipcode = address?.zipcode,
        geolocationDto = geolocationDto
    )
}