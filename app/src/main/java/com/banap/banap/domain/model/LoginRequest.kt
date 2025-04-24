package com.banap.banap.domain.model

data class LoginRequest(
    val email: String,
    val password: String,
    val typeUser: Int
)