package com.banap.banap.domain.model.use_case

class ValidateName {

    fun execute (password: String) : ValidationResult {
        if (password.length < 2) {
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