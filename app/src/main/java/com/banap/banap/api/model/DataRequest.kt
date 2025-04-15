package com.banap.banap.api.model

data class DataRequest(
    val email: String,
    val password: String,
    val typeUser: Int
)