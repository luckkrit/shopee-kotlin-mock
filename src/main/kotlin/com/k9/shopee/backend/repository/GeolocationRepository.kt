package com.k9.shopee.backend.repository;

import com.k9.shopee.backend.models.Geolocation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GeolocationRepository : JpaRepository<Geolocation, Long> {
}