package com.k9.shopee.backend.repository;

import com.k9.shopee.backend.models.UserDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDetailRepository : JpaRepository<UserDetail, Long> {
}