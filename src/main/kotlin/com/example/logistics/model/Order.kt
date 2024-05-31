package com.example.logistics.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "t_orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer,

    @Column(name = "start_location")
    val startLocation: String?,

    @Column(name = "end_location", nullable = false)
    val endLocation: String,

    @Column(name = "order_date", nullable = false)
    val orderDate: LocalDate,

    @Column(name = "order_status", nullable = false)
    val orderStatus: String,

    @Column(name = "quantity", nullable = false)
    val quantity: Int
)
