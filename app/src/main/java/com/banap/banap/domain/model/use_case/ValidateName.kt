package com.banap.banap.domain.model.use_case

class ValidateName {

    fun execute (name: String) : ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "O nome não pode estar em branco"
            )
        }

        if (name.length < 2) {
            return ValidationResult(
                successful = false,
                errorMessage = "O nome precisa ter pelo menos 2 caracteres"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}