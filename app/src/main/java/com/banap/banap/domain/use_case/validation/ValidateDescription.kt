package com.banap.banap.domain.use_case.validation

class ValidateDescription {

    fun execute (description: String) : ValidationResult {
        if (description.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "A descrição não pode estar em branco"
            )
        }

        if (description.length > 40) {
            return ValidationResult(
                successful = false,
                errorMessage = "A descrição não pode ter mais que 40 caracteres"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}