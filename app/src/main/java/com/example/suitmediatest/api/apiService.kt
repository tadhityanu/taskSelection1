package com.example.suitmediatest.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface apiService {
    @GET("api/users")
    fun getUsers(): Call<ResponseUser>
}