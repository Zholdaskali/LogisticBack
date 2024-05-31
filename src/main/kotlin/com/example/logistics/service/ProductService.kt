package com.example.logistics.service

import com.example.logistics.exception.CustomerNotFoundException
import com.example.logistics.exception.ProductNotFoundException
import com.example.logistics.model.Order
import com.example.logistics.model.Product
import com.example.logistics.repository.ProductRepository
import com.example.logistics.response.MessagedResponse
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun getByCustomerId(customerId: Long): List<Product> {
        return productRepository.findByCustomerId(customerId)
    }
    fun add(product: Product): Product {
        return productRepository.save(product)
    }
    fun delete(productId: Long) {
        if (!productRepository.existsById(productId)) {
            throw ProductNotFoundException()
        }
        productRepository.deleteById(productId)
    }
}