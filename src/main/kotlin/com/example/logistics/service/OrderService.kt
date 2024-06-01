package com.example.logistics.service

import com.example.logistics.exception.OrderNotFoundException
import com.example.logistics.model.Order
import com.example.logistics.model.Product
import com.example.logistics.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    fun getByCustomerId(customerId: Long): List<Order> {
        return orderRepository.findByCustomerId(customerId)
    }

    fun add(order: Order): Order {
        return orderRepository.save(order)
    }

    fun delete(orderId: Long) {
        if (!orderRepository.existsById(orderId)) {
            throw OrderNotFoundException()
        }
        orderRepository.deleteById(orderId)
    }
}