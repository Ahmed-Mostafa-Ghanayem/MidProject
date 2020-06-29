package com.mid.project

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginAPI {
    @POST("/login")
    fun login(@Body param: LoginParam): Call<Response>
}