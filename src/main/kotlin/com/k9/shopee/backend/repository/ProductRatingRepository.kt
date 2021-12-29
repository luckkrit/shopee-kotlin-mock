package com.k9.shopee.backend.repository;

import com.k9.shopee.backend.models.ProductRating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRatingRepository : JpaRepository<ProductRating, Long> {
}