package com.banap.banap.login.model

fun checkCredentials (
    email: String,
    password: String
) : Boolean {
    var isCredentialsCorrect = false

    if (email == "email@gmail.com" && password == "Preto159") {
        isCredentialsCorrect = true
    }

    return isCredentialsCorrect
}