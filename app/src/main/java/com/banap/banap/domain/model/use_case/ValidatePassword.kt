package com.banap.banap.domain.model.use_case

class ValidatePassword {

    fun execute (password: String) : ValidationResult {
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