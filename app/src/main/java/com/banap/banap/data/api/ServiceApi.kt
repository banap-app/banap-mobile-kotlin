package com.banap.banap.data.api

import com.banap.banap.data.model.DataResponse
import retrofit2.http.GET

interface ServiceApi {
     @GET("photos")
     suspend fun getData(): List<DataResponse>
}