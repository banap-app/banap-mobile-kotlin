package com.banap.banap.model

import androidx.navigation.NavController

fun checkCredentials (
    fieldValues: MutableList<String>?,
    navigationController: NavController?
) {
    if (
        ((fieldValues?.get(0) ?: "") == "email@gmail.com") && ((fieldValues?.get(1) ?: "") == "123")
    ) {
        navigationController?.navigate("Home")
    }
}