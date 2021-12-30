package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.user.GeolocationDto
import com.k9.shopee.backend.models.Geolocation

object GeolocationUtil {
    fun createGeolocation(geolocationDto: GeolocationDto): Geolocation {
        val geolocation = Geolocation()
        geolocation.latitude = geolocationDto.latitude
        geolocation.longitude = geolocationDto.longitude
        return geolocation
    }

    fun updateGeolocation(geolocation: Geolocation, geolocationDto: GeolocationDto): Geolocation {
        geolocation.latitude = geolocationDto.latitude
        geolocation.longitude = geolocationDto.longitude
        return geolocation
    }

    fun getGeolocationDto(geolocation: Geolocation?): GeolocationDto =
        GeolocationDto(latitude = geolocation?.latitude, longitude = geolocation?.longitude)
}