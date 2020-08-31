package com.example.reddittest.network.entities

import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("modhash") val modhash: String,
    @SerializedName("children") val data: List<ChildrenDataDto>,
    @SerializedName("after") val after: String,
    @SerializedName("before") val before: String
)