package com.k9.shopee.backend.repository;

import com.k9.shopee.backend.models.CartProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartProductRepository : JpaRepository<CartProduct, Long> {
}