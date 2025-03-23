package com.banap.banap.api.model

import kotlinx.serialization.Serializable

@Serializable
data class DataResponse(
    val id: String,
    val img_src: String
)
