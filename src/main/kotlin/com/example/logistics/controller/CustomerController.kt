package com.example.logistics.controller

import com.example.logistics.model.Customer
import com.example.logistics.response.MessagedResponse
import com.example.logistics.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = ["*"])
class CustomerController(
    private val customerService: CustomerService
) {
    @GetMapping("/{customerId}")
    fun getCustomerById(
        @PathVariable customerId: Long
    ): MessagedResponse<Customer> {
        return customerService.getById(customerId).let(MessagedResponse.Companion::of)
    }
}