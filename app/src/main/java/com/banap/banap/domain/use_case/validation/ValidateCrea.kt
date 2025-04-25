package com.banap.banap.domain.use_case.validation

class ValidateCrea {

    fun execute (crea: String) : ValidationResult {
        if (crea.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "O CREA não pode estar em branco"
            )
        }

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