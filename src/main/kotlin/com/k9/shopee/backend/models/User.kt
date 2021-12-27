package com.k9.shopee.backend.models

import javax.persistence.*
import javax.validation.constraints.Email

@Entity
@Table(name = "users")
open class User {
    @SequenceGenerator(name = "userSeqGen", sequenceName = "user_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne
    @JoinColumn(name = "user_detail_id")
    open var userDetail: UserDetail? = null

    @OneToOne
    @JoinColumn(name = "address_id")
    open var address: Address? = null

    @OneToMany(mappedBy = "user")
    open var carts: MutableList<Cart> = mutableListOf()

    @Column(name = "email")
    open var email: String? = null

    @Column(name = "username")
    open var username: String? = null

    @Column(name = "password")
    open var password: String? = null
}