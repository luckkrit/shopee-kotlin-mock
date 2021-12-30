package com.k9.shopee.backend.utils

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

object PageableUtil {
    fun getPageable(
        optionalLimit: Optional<Int>,
        optionalSort: Optional<String> = Optional.of("asc"),
        total: Int,
        sortBy: String = "id"
    ): Pageable {
        val limit = if (optionalLimit.isPresent) optionalLimit.get() else total
        val direction =
            if (optionalSort.isPresent)
                if (optionalSort.get() == "asc") Sort.Direction.ASC
                else Sort.Direction.DESC
            else Sort.Direction.ASC
        return PageRequest.of(0, limit, direction, sortBy)
    }
}