package com.example.logistics.service

import com.example.logistics.exception.WarehouseNotFountException
import com.example.logistics.model.Warehouse
import com.example.logistics.repository.WarehouseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class WarehouseService(
    private val warehouseRepository: WarehouseRepository
) {
    fun getById(warehouseId: Long): Warehouse {
        return warehouseRepository.findById(warehouseId).orElseThrow{ WarehouseNotFountException() }
    }
}