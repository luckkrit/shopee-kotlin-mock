package com.k9.shopee.backend.utils

import com.k9.shopee.backend.dtos.user.NameDto
import com.k9.shopee.backend.models.UserDetail

object NameUtil {
    fun getNameDto(userDetail: UserDetail?): NameDto =
        NameDto(firstname = userDetail?.firstname, lastname = userDetail?.lastname)
}