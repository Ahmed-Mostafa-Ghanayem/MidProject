package com.mid.project

import retrofit2.Call
import retrofit2.Callback

class LoginModel(private val loginAPI: ILoginAPI) : ILoginModel {

    override fun login(
        email: String,
        password: String,
        successAction: (String) -> Unit,
        failureAction: (String) -> Unit
    ) {
        loginAPI.login(LoginParam(email, password))
            .enqueue(object : Callback<Response> {
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    failureAction(t.message!!)
                }

                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    successAction("Success")
                }
            })

    }
}