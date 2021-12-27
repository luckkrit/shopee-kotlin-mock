package com.k9.shopee.backend.models

import javax.persistence.*

@Entity
@Table(name = "user_details")
open class UserDetail {
    @SequenceGenerator(name = "userDetailSeqGen", sequenceName = "user_detail_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userDetailSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "firstname")
    open var firstname: String? = null

    @Column(name = "lastname")
    open var lastname: String? = null

    @Column(name = "phone")
    open var phone: String? = null
}