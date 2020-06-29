package com.mid.project

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val retrofit by lazy {
    Retrofit.Builder().baseUrl("https://midproject.getsandbox.com")
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun <I> createAPI(clazz: Class<I>): I = retrofit.create(clazz)