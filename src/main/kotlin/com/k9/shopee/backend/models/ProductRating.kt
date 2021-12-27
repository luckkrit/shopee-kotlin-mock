package com.k9.shopee.backend.models

import javax.persistence.*

@Entity
@Table(name = "product_ratings")
open class ProductRating {
    @SequenceGenerator(name = "productRatingSeqGen", sequenceName = "product_rating_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productRatingSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "rate")
    open var rate: Float? = null

    @Column(name = "count")
    open var count: Long? = null

}