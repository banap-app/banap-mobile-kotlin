package com.banap.banap.domain.repository

import com.banap.banap.data.model.LoginResponse
import com.banap.banap.data.model.TokenVerificationResponse

interface LoginRepository {
    suspend fun authenticationUser(email: String, password: String): LoginResponse
    suspend fun verifyToken(token: String): TokenVerificationResponse
}