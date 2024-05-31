package com.example.logistics.controller

import com.example.logistics.model.Product
import com.example.logistics.model.request.ProductRequest
import com.example.logistics.response.MessagedResponse
import com.example.logistics.service.CustomerService
import com.example.logistics.service.ProductService
import com.example.logistics.service.WarehouseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = ["*"])
class ProductController(
    private val productService: ProductService,
    private val customerService: CustomerService,
    private val warehouseService: WarehouseService
) {
    @GetMapping("{customerId}")
    fun getByCustomerId(
        @PathVariable customerId: Long
    ): MessagedResponse<List<Product>> {
        return productService.getByCustomerId(customerId).let(MessagedResponse.Companion::of)
    }
    @PostMapping("/products")
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity< MessagedResponse< Product>> {
        val customer = customerService.getById(request.product.customer.id)
        val warehouse = warehouseService.getById(request.product.warehouse.id)

        val product = Product(
            productName = request.product.productName,
            startDate = LocalDate.parse(request.product.startDate),
            expirationDate = LocalDate.parse(request.product.expirationDate),
            quantity = request.product.quantity,
            warehouse = warehouse,
            customer = customer
        )

        val createdProduct = productService.add(product)
        return ResponseEntity.ok(MessagedResponse.of(createdProduct))
    }
    @DeleteMapping("{productId}")
    fun deleteProduct(
        @PathVariable productId: Long
    ): ResponseEntity<MessagedResponse<String>> {
        productService.delete(productId)
        return ResponseEntity.ok(MessagedResponse.of("Product deleted successfully"))
    }
}