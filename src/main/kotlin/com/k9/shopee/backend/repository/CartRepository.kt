package com.k9.shopee.backend.repository;

import com.k9.shopee.backend.models.Cart
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CartRepository : JpaRepository<Cart, Long> {
    fun findAllByDateBetween(pageable: Pageable, startdate: Date, enddate: Date): Page<Cart>
    fun findAllByDateGreaterThanEqual(pageable: Pageable, startdate: Date): Page<Cart>
    fun findAllByDateLessThanEqual(pageable: Pageable, enddate: Date): Page<Cart>
    fun findByUserId(userId: Long): List<Cart>
}