package com.example.logistics.repository

import com.example.logistics.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    fun findByCustomerId(customerId: Long): List<Product>
}