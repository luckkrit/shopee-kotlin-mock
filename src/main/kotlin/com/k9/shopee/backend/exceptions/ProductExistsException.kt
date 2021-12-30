package com.k9.shopee.backend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.CONFLICT)
class ProductExistsException(message: String?) : RuntimeException(message) {
}