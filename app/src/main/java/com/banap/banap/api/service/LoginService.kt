package com.banap.banap.api.service

import com.banap.banap.api.model.DataRequest
import com.banap.banap.api.model.DataResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
     @POST("/api/auth/user/login")
     suspend fun authenticationUser(@Body dataRequest: DataRequest): DataResponse
}