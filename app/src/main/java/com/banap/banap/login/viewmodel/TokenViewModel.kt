package com.banap.banap.login.viewmodel

import androidx.lifecycle.ViewModel
import com.banap.banap.login.model.TokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TokenViewModel @Inject constructor (
    private val tokenManager: TokenManager
) : ViewModel() {
    fun saveToken(token: String) {
        tokenManager.saveToken(token)
    }

    fun getToken() : String? {
        return tokenManager.getToken()
    }

    fun clearToken() {
        tokenManager.clearToken()
    }
}