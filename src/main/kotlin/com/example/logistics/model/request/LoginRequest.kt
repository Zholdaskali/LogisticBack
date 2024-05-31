package com.example.logistics.model.request


data class LoginRequest(
    val customerName: String,
    val password: String
)