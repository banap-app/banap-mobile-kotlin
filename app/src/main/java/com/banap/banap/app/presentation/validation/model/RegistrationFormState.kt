package com.banap.banap.app.presentation.validation.model

data class RegistrationFormState(
    val name: String = "",
    val nameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val crea: String = "",
    val creaError: String? = null,
    val description: String = "",
    val descriptionError: String? = null,
    val cultivation: String = "",
    val cultivationError: String? = null
)
