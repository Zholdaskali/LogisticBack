package com.example.logistics.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "t_products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "product_name", nullable = false)
    val productName: String,

    @Column(name = "start_date", nullable = false)
    val startDate: LocalDate,

    @Column(name = "expiration_date", nullable = false)
    val expirationDate: LocalDate,

    @Column(nullable = false)
    val quantity: Int,

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    val  warehouse: Warehouse,

    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false)
    val  customer: Customer
)
