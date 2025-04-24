package com.banap.banap.domain.repository

import com.banap.banap.data.model.LoginResponse

interface LoginRepository {
    suspend fun authenticationUser(email: String, password: String): LoginResponse
}