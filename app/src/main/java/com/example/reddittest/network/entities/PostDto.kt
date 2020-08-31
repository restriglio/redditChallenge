package com.example.reddittest.network.entities

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("author") val author: String,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("num_comments") val numComments: Int,
    @SerializedName("created_utc") val created: Long
)