package com.example.logistics.repository

import com.example.logistics.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun existsByCustomerName(login: String): Boolean
    fun findByCustomerName(login: String): Optional<Customer>
}