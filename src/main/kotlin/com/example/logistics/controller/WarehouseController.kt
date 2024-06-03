package com.example.logistics.controller

import com.example.logistics.model.Warehouse
import com.example.logistics.repository.WarehouseRepository
import com.example.logistics.response.MessagedResponse
import com.example.logistics.service.WarehouseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/warehouses")
@CrossOrigin(origins = ["*"])
class WarehouseController(
    private val warehouseRepository: WarehouseRepository,
    private val warehouseService: WarehouseService
) {
    @GetMapping
    fun getAll(): MessagedResponse<List<Warehouse>> {
        return warehouseRepository.findAll().let(MessagedResponse.Companion::of)
    }
    @PostMapping("/add")
    fun createWarehouse(@RequestBody warehouse: Warehouse): ResponseEntity<MessagedResponse<Warehouse>> {
        val createdWarehouse = warehouseService.createWarehouse(warehouse)
        return ResponseEntity.ok(MessagedResponse.of(createdWarehouse))
    }
}