package com.banap.banap.domain.model.use_case

class ValidateCrea {

    fun execute (crea: String) : ValidationResult {
        if (crea.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "O CREA precisa ter 8 caracteres"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}