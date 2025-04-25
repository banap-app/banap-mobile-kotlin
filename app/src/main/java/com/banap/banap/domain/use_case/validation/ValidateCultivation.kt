package com.banap.banap.domain.use_case.validation

class ValidateCultivation {

    fun execute (cultivation: String) : ValidationResult {
        if (cultivation.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "A cultura não pode estar em branco"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}