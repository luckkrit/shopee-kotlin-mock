package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.user.NameDto
import com.k9.shopee.backend.models.UserDetail

object UserDetailUtil {
    fun createUserDetail(nameDto: NameDto, phone: String?): UserDetail {
        val userDetail = UserDetail()
        userDetail.firstname = nameDto.firstname
        userDetail.lastname = nameDto.lastname
        userDetail.phone = phone
        return userDetail
    }

    fun updateUserDetail(userDetail: UserDetail, nameDto: NameDto, phone: String?): UserDetail {
        userDetail.firstname = nameDto.firstname
        userDetail.lastname = nameDto.lastname
        userDetail.phone = phone
        return userDetail
    }
}