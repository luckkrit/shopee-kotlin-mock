package com.k9.shopee.backend.models

import com.k9.shopee.backend.models.Product
import javax.persistence.*

@Entity
@Table(name = "categories")
open class Category {
    @SequenceGenerator(name = "categorySeqGen", sequenceName = "category_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToMany(mappedBy = "category")
    open var products: MutableList<Product> = mutableListOf()

    @Column(name = "title")
    open var title: String? = null
}