package com.example.logistics.model.request

import java.time.LocalDate

data class OrderRequest(
    val customerId: Long,
    val startLocation: String?,
    val endLocation: String,
    val orderDate: String,
    val orderStatus: String,
    val quantity: Int
)