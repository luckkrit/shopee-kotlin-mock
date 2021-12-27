package com.k9.shopee.backend.models

import javax.persistence.*

@Entity
@Table(name = "cart_products")
open class CartProduct {
    @SequenceGenerator(name = "cartProductSeqGen", sequenceName = "cart_product_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartProductSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "cart_id")
    open var cart: Cart? = null

    @ManyToOne
    @JoinColumn(name = "product_id")
    open var product: Product? = null

    @Column(name = "quantity")
    open var quantity: Long? = null
}