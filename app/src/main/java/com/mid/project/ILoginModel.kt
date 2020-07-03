package com.mid.project

interface ILoginModel {
    fun login(
        email: String,
        password: String,
        successAction: (String) -> Unit,
        failureAction: (String) -> Unit
    )
}
