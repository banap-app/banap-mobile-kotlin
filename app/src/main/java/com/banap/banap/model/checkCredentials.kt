package com.banap.banap.model

import androidx.navigation.NavController

fun checkCredentials (
    fieldValues: MutableList<String>?,
    navigationController: NavController?
) {
    if (
        ((fieldValues?.get(0) ?: "") == "gilmar@gmail.com") && ((fieldValues?.get(1) ?: "") == "Senha123")
    ) {
        navigationController?.navigate("Home")
    }
}