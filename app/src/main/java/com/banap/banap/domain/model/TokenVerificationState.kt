package com.banap.banap.domain.model

import com.banap.banap.data.model.TokenVerificationResponse

data class TokenVerificationState(
    val isLoading: Boolean = false,
    val response: TokenVerificationResponse? = null,
    val error: String = ""
)