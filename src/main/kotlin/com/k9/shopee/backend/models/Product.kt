package com.k9.shopee.backend.models

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "products")
open class Product {
    @SequenceGenerator(name = "productSeqGen", sequenceName = "product_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "category_id")
    open var category: Category? = null

    @OneToOne
    @JoinColumn(name = "product_rating_id")
    open var productRating: ProductRating? = null

    @OneToMany(mappedBy = "product")
    open var cartProducts: MutableList<CartProduct> = mutableListOf()

    @Lob
    @Column(name = "description")
    open var description: String? = null

    @Column(name = "title")
    open var title: String? = null

    @Column(name = "price")
    open var price: Float? = null

    @Column(name = "image")
    open var image: String? = null
}