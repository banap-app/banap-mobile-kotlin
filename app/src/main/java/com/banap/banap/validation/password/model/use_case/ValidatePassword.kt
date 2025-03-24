package com.banap.banap.validation.password.model.use_case

import com.banap.banap.validation.ValidationResult

class ValidatePassword {

    fun execute (password: String) : ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "A senha não pode estar em branco"
            )
        }

        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "A senha precisa ter pelo menos 8 caracteres"
            )
        }

        val containsLetterAndDigits = password.any { it.isDigit() }
                &&
                password.any { it.isLetter() }

        if (!containsLetterAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "A senha precisa ter pelo menos uma letra e um digito"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}