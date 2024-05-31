package com.example.logistics.model.request

data class RegisterRequest(
    val password: String,
    val customerName: String,
    val customerPhone: String
)