package com.k9.shopee.backend.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "carts")
open class Cart {
    @SequenceGenerator(name = "cartSeqGen", sequenceName = "cart_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToMany(mappedBy = "cart")
    open var cartProducts: MutableList<CartProduct> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "user_id")
    open var user: User? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    open var date: Date? = null
}