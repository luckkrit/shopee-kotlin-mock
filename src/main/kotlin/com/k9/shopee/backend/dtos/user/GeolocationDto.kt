package com.k9.shopee.backend.dtos.user

import com.fasterxml.jackson.annotation.JsonProperty

data class GeolocationDto(@JsonProperty("lat") val latitude: Float=0F, @JsonProperty("long") val longitude: Float = 0F)
