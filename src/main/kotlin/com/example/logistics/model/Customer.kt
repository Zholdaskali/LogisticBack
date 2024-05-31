package com.example.logistics.model

import jakarta.persistence.*

@Entity
@Table(name = "t_customers")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "customer_name")
    val customerName: String,

    @Column(name = "customer_phone")
    val customerPhone: String? = null,

    @Column(name = "password")
    val password: String? = null
)