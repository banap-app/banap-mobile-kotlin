package com.banap.banap.domain.model.use_case

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
