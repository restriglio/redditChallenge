package com.example.reddittest.network.entities

import com.google.gson.annotations.SerializedName

data class PostDataDto(
    @SerializedName("kind") val kind: String,
    @SerializedName("data") val data: DataDto
)