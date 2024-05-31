package com.example.logistics.repository

import com.example.logistics.model.Warehouse
import org.springframework.data.jpa.repository.JpaRepository

interface WarehouseRepository : JpaRepository<Warehouse, Long> {
}