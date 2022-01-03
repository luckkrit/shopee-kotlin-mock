package com.k9.shopee.backend.controllers

import com.k9.shopee.backend.dtos.category.CategoryDto
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import reactor.core.publisher.Mono


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CategoryControllerTest() {

    @LocalServerPort
    var port: Int = 0
    private val log = LoggerFactory.getLogger(javaClass)
    private lateinit var webClient: WebClient

    private fun baseUri(): String = "http://localhost:$port/api"
    private fun getWebClient(): WebClient = WebClient.builder().baseUrl(baseUri()).build()

    @BeforeAll
    fun initWebClient() {
        webClient = getWebClient()
        log.info("init web client")
    }

    /**
     * An example of webclient
     * https://www.fabrizioduroni.it/2020/12/23/rest-template-webclient-spring-boot/
     */
    @Test
    @Order(1)
    fun getAllCategories() {
        val result = webClient
            .get()
            .uri("/products/categories")
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
            .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
            .toEntity<List<CategoryDto>>().block()
        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertEquals(4, result?.body?.size)

    }

}