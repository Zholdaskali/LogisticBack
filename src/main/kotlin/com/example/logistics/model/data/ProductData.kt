package com.example.logistics.model.data

import java.math.BigDecimal

data class ProductData(
    val productName: String,
    val startDate: String,
    val expirationDate: String,
    val quantity: Int,
    val customer: CustomerData,
    val warehouse: WarehouseData
)