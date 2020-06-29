package com.mid.project


fun createPresenter(view: ILoginView): LoginPresenter {
    return LoginPresenter(view, createModel())
}

fun createModel(): LoginModel {
    return LoginModel(createAPI(ILoginAPI::class.java))
}
