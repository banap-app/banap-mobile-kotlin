package com.banap.banap.validation

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
