package com.k9.shopee.backend.controllers

import com.k9.shopee.backend.dtos.category.CategoryDto
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class CategoryControllerTest(@Autowired private val webTestClient: WebTestClient) {

    private val log = LoggerFactory.getLogger(javaClass)


    /**
     * An example of WebClient, See
     * https://www.fabrizioduroni.it/2020/12/23/rest-template-webclient-spring-boot/
     * anyway, WebTestClient is better for testing purposes, See
     * https://spring.getdocs.org/en-US/spring-framework-docs/docs/testing/integration-testing/webtestclient.html#kotlin:kotlin-spring-projects-in-kotlin:testing.adoc#kotlin-webtestclient-issue
     */
    @Test
    @Order(1)
    fun getAllCategories() {
        webTestClient.get().uri("/products/categories").exchange().expectStatus().isOk.expectBodyList<CategoryDto>()
            .hasSize(4)
    }

}