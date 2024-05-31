package com.example.logistics.repository

import com.example.logistics.model.Customer
import com.example.logistics.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
}