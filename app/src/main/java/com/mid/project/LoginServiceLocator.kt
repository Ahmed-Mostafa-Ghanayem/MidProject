package com.mid.project

import androidx.core.util.PatternsCompat


fun createPresenter(view: ILoginView): LoginPresenter {
    return LoginPresenter(view, createModel(), createEmailValidator())
}

fun createEmailValidator(): (String) -> Boolean = { email ->
    PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
}

fun createModel(): LoginModel {
    return LoginModel(createAPI(ILoginAPI::class.java))
}
