package com.example.logistics.controller

import com.example.logistics.model.Order
import com.example.logistics.model.Product
import com.example.logistics.model.request.OrderRequest
import com.example.logistics.repository.OrderRepository
import com.example.logistics.response.MessagedResponse
import com.example.logistics.service.CustomerService
import com.example.logistics.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = ["*"])
class OrderController(
    private val orderService: OrderService,
    private val customerService: CustomerService
) {
    @GetMapping("{customerId}")
    fun getByCustomerId(
        @PathVariable customerId: Long
    ): MessagedResponse<List<Order>> {
        return orderService.getByCustomerId(customerId).let(MessagedResponse.Companion::of)
    }

    @PostMapping("/add")
    fun createOrder(@RequestBody request: OrderRequest): ResponseEntity<MessagedResponse<String>> {
        val customer = customerService.getById(request.customerId)

        val order = Order(
            customer = customer,
            startLocation = request.startLocation,
            endLocation = request.endLocation,
            orderDate = LocalDate.parse(request.orderDate),
            orderStatus = request.orderStatus,
            quantity = request.quantity
        )

        val createdOrder = orderService.add(order)
        return ResponseEntity.ok(MessagedResponse.of("Заказ успешно создан!!!"))
    }

    @DeleteMapping("{orderId}")
    fun deleteProduct(
        @PathVariable orderId: Long
    ): ResponseEntity<MessagedResponse<String>> {
        orderService.delete(orderId)
        return ResponseEntity.ok(MessagedResponse.of("Заказ успешно удален!!!"))
    }

}