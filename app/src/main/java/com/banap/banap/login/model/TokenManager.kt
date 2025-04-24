package com.banap.banap.login.model

import android.content.Context
import javax.inject.Inject

class TokenManager @Inject constructor (
    private val context: Context,
) {
    private val prefs = context.getSharedPreferences("auth_token", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    fun getToken() : String? {
        return prefs.getString("token", null)
    }

    fun clearToken() {
        prefs.edit().remove("token").apply()
    }

}