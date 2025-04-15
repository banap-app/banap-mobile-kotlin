package com.banap.banap.api.model

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.banap.banap.api.network.ServiceProvider
import com.banap.banap.login.model.TokenManager
import com.banap.banap.validation.LoginState
import com.banap.banap.validation.login.model.LoginFormEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class DataViewModel (
    application: Application
) : AndroidViewModel(application) {
    private val tokenManager = TokenManager(application.applicationContext)

    var state by mutableStateOf(LoginState())

    private val validationEventChannel = Channel<ValidationAuthenticate>()
    val validationEvent = validationEventChannel.receiveAsFlow()

    fun onEvent (event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.Email -> {
                state = state.copy(
                    email = event.email
                )
            }

            is LoginFormEvent.Password -> {
                state = state.copy(
                    password = event.password
                )
            }

            is LoginFormEvent.Submit -> {
                authenticateUser()
            }
        }
    }

    private fun authenticateUser() {
        viewModelScope.launch {
            try {
                val response = ServiceProvider.retrofitService.authenticationUser(
                    DataRequest(
                        email = state.email,
                        password = state.password,
                        typeUser = 1
                    )
                )

                if (response.success) {
                    tokenManager.saveToken(response.token)

                    tokenManager.token.collect { token ->
                        println("Token armazenado: $token")
                    }

                    validationEventChannel.send(ValidationAuthenticate.Success)
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    sealed class ValidationAuthenticate {
        object Success : ValidationAuthenticate()
    }
}