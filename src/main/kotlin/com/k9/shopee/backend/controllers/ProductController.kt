package com.k9.shopee.backend.controllers

import com.k9.shopee.backend.dtos.AddProductDto
import com.k9.shopee.backend.dtos.ProductDto
import com.k9.shopee.backend.dtos.UpdateProductDto
import com.k9.shopee.backend.services.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {
    @GetMapping
    fun getAllProducts(
        @RequestParam limit: Optional<Int>,
        @RequestParam sort: Optional<String>
    ): ResponseEntity<List<ProductDto>> =
        ResponseEntity.ok(productService.getAllProducts(limit, sort))

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<ProductDto> {
        val optionalProductDto = productService.getProduct(id)
        return if (optionalProductDto.isPresent) ResponseEntity.ok(optionalProductDto.get()) else ResponseEntity.notFound()
            .build()
    }

    @PostMapping
    fun postProduct(@RequestBody addProductDto: AddProductDto): ResponseEntity<Any> {
        val optionalProductDto = productService.addProduct(addProductDto)
        return if (optionalProductDto.isPresent) ResponseEntity.created(URI.create("/products/${optionalProductDto.get().id}"))
            .build() else ResponseEntity.notFound()
            .build()
    }

    @PutMapping("/{id}")
    fun putProduct(@PathVariable id: Long, @RequestBody updateProductDto: UpdateProductDto): ResponseEntity<Any> {
        val optionalProductDto = productService.updateProduct(id, updateProductDto)
        return if (optionalProductDto.isPresent) ResponseEntity.noContent().build() else ResponseEntity.notFound()
            .build()
    }

    @PatchMapping("/{id}")
    fun patchProduct(@PathVariable id: Long, @RequestBody updateProductDto: UpdateProductDto): ResponseEntity<Any> {
        val optionalProductDto = productService.updateProduct(id, updateProductDto)
        return if (optionalProductDto.isPresent) ResponseEntity.noContent().build() else ResponseEntity.notFound()
            .build()
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Any> {
        val optionalProductDto = productService.deleteProduct(id)
        return if (optionalProductDto.isPresent) ResponseEntity.noContent().build() else ResponseEntity.notFound()
            .build()
    }
}