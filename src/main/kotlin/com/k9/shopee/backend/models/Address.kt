package com.k9.shopee.backend.models

import javax.persistence.*

@Entity
@Table(name = "addresses")
open class Address {
    @SequenceGenerator(name = "addressSeqGen", sequenceName = "address_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne
    @JoinColumn(name = "user_id")
    open var user: User? = null

    @OneToOne
    @JoinColumn(name = "geolocation_id")
    open var geolocation: Geolocation? = null

    @Column(name = "zipcode")
    open var zipcode: String? = null

    @Column(name = "number")
    open var number: Long? = null

    @Column(name = "city")
    open var city: String? = null

    @Column(name = "street")
    open var street: String? = null

}