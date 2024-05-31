package com.example.logistics.model

import jakarta.persistence.*

@Entity
@Table(name = "t_warehouses")
data class Warehouse(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "warehouse_name", nullable = false)
    val warehouseName: String,

    @Column(name = "warehouse_address", nullable = false)
    val  warehouseAddress: String
)
