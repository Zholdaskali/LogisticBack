package com.example.logistics.service

import com.example.logistics.exception.CustomerNotFoundException
import com.example.logistics.model.Customer
import com.example.logistics.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    fun getById(userId: Long): Customer {
        return customerRepository.findById(userId).orElseThrow { CustomerNotFoundException() }
    }
}