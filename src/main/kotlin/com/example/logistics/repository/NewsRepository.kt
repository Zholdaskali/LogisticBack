package com.example.logistics.repository

import com.example.logistics.model.Customer
import com.example.logistics.model.News
import org.springframework.data.jpa.repository.JpaRepository

interface NewsRepository : JpaRepository<News, Long> {
}