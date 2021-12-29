package com.k9.shopee.backend.repository;

import com.k9.shopee.backend.models.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository : JpaRepository<Cart, Long> {
}