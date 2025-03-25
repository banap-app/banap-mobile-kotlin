package com.banap.banap.validation.cultivation.model.use_case

import com.banap.banap.validation.ValidationResult

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