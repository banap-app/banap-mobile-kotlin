package com.banap.banap.data.repository

import com.banap.banap.domain.model.LoginRequest
import com.banap.banap.data.model.LoginResponse
import com.banap.banap.data.model.TokenVerificationResponse
import com.banap.banap.data.remote.login.LoginService
import com.banap.banap.domain.model.TokenVerificationRequest
import com.banap.banap.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val service: LoginService
) : LoginRepository {
    override suspend fun authenticationUser(email: String, password: String): LoginResponse {
        return service.authenticationUser(
            LoginRequest(email, password, 1)
        )
    }

    override suspend fun verifyToken(token: String): TokenVerificationResponse {
        return service.verifyToken(
            TokenVerificationRequest(token)
        )
    }
}