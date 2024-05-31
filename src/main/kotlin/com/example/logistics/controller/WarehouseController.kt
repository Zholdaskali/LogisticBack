package com.example.logistics.controller

import com.example.logistics.model.Warehouse
import com.example.logistics.repository.WarehouseRepository
import com.example.logistics.response.MessagedResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/warehouses")
@CrossOrigin(origins = ["*"])
class WarehouseController(
    private val warehouseRepository: WarehouseRepository
) {
    @GetMapping
    fun getAll(): MessagedResponse<List<Warehouse>> {
        return warehouseRepository.findAll().let(MessagedResponse.Companion::of)
    }
}