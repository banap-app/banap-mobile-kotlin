package com.banap.banap.domain.model

import com.banap.banap.data.model.LoginResponse

data class LoginState(
    val isLoading: Boolean = false,
    val response: LoginResponse? = null,
    val error: String = ""
)