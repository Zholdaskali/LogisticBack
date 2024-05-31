package com.example.logistics.service

import com.example.logistics.exception.CustomerNotFoundException
import com.example.logistics.exception.UserAlreadyExistsException
import com.example.logistics.exception.WrongCredentialsException
import com.example.logistics.model.Customer
import com.example.logistics.repository.CustomerRepository
import kz.enactus.ecoalmaty.api.utils.encoder.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val customerRepository: CustomerRepository) {

    private val passwordEncoder = BCryptPasswordEncoder(10)

    fun register(customerName: String, password: String, customerPhone: String): Long? {
        if (customerRepository.existsByCustomerName(customerName)) {
            throw UserAlreadyExistsException()
        }

        val encodedPassword = passwordEncoder.hash(password)
        val customer = Customer(password = encodedPassword, customerName = customerName, customerPhone = customerPhone)
        customerRepository.save(customer)

        return customer.id
    }

    fun login(customerName: String, password: String): Long? {
        val customer = customerRepository.findByCustomerName(customerName)
            .orElseThrow { CustomerNotFoundException() }

        val passwordMatches = customer.password?.let {
            passwordEncoder.check(password, it)
        } ?: false

        if (!passwordMatches) {
            throw WrongCredentialsException()
        }

        return customer.id
    }
}