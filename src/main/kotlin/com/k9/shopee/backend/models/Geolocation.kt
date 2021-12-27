package com.k9.shopee.backend.models

import javax.persistence.*

@Entity
@Table(name = "geolocations")
open class Geolocation {
    @SequenceGenerator(name = "geolocationSeqGen", sequenceName = "geolocation_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geolocationSeqGen")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "latitude")
    open var latitude: Long? = null

    @Column(name = "longtitude")
    open var longtitude: Long? = null
}