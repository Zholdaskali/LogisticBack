package com.example.logistics.controller

import com.example.logistics.model.request.LoginRequest
import com.example.logistics.model.request.RegisterRequest
import com.example.logistics.service.AuthenticationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = ["*"])
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): Long? {
        return authenticationService.register(registerRequest.customerName, registerRequest.password, registerRequest.customerPhone)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): Long? {
        return authenticationService.login(loginRequest.customerName, loginRequest.password)
    }
}
////
//{
//    "customerName": "John Doe",
//    "customerPhone": "1234567890",
//    "password": "password1231"
//}
//{
//    "customerName": "Zholdaskali Erkebulan",
//    "customerPhone": "87478408845",
//    "password": "password1231"
//}