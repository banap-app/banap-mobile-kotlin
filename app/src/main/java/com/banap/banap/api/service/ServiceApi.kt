package com.banap.banap.api.service

import com.banap.banap.api.model.DataResponse
import retrofit2.http.GET

interface ServiceApi {
     @GET("photos")
     suspend fun getData(): List<DataResponse>
}