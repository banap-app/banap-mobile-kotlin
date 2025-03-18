package com.banap.banap.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banap.banap.domain.model.use_case.ValidateName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NameTextFieldViewModel (
    private val validateName: ValidateName = ValidateName()
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEventNameTextField>()
    val validatioEventName = validationEventChannel.receiveAsFlow()

    fun onEvent (event: NameTextFieldFormEvent) {
        when (event) {
            is NameTextFieldFormEvent.NameChanged -> {
                state = state.copy(
                    name = event.name
                )
            }

            is NameTextFieldFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val nameResult = validateName.execute(state.name)

        if (!nameResult.successful) {
            state = state.copy(
                nameError = nameResult.errorMessage
            )
            return
        }

        state = state.copy(
            nameError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationEventNameTextField.Success)
        }
    }

    sealed class ValidationEventNameTextField {
        object Success : ValidationEventNameTextField()
    }
}