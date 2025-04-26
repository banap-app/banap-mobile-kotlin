package com.banap.banap.data.model

data class TokenVerificationResponse (
    val decodedToken: String,
    val success: Boolean
)