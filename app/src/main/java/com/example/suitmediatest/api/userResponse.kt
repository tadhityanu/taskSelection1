package com.example.suitmediatest.api

import com.google.gson.annotations.SerializedName

data class ResponseUser(

    @field:SerializedName("data")
    val data: List<userResponse>? = null
)

data class userResponse(
    @field:SerializedName("id")
    val id : Int,

    @field:SerializedName("email")
    val email : String,

    @field:SerializedName("first_name")
    val first_name : String,

    @field:SerializedName("last_name")
    val last_name: String,

    @field:SerializedName("avatar")
    val avatar : String,
)


