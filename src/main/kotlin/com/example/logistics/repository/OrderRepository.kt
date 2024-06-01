package com.example.logistics.repository

import com.example.logistics.model.Customer
import com.example.logistics.model.Order
import com.example.logistics.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
    fun findByCustomerId(customerId: Long): List<Order>
}