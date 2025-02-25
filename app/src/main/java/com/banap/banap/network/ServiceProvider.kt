package com.banap.banap.network

import com.banap.banap.data.api.ServiceApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()

object ServiceProvider {
    val retrofitService: ServiceApi by lazy {
        retrofit.create(ServiceApi::class.java)
    }
}