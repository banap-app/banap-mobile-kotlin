package com.banap.banap.view

sealed class ProducerRegistrationFormEvent {
    data class NameChanged(val name: String) : ProducerRegistrationFormEvent()
    data class EmailChanged(val email: String) : ProducerRegistrationFormEvent()
    data class PasswordChanged(val password: String) : ProducerRegistrationFormEvent()

    object Submit: ProducerRegistrationFormEvent()
}