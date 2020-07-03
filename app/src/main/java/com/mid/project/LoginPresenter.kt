package com.mid.project

import java.lang.ref.WeakReference

class LoginPresenter(
    view: ILoginView,
    private val model: ILoginModel,
    private val emailValidator: (String) -> Boolean
) {
    private val viewReference = WeakReference<ILoginView>(view)

    fun validateAndLogin(email: String, password: String) {
        if (validate(email)) {
            getView()?.showLoading(true)
            model.login(email, password, { successMessage: String ->
                getView()?.showLoading(false)
                getView()?.showMessage(successMessage)
            }, { failureMessage: String ->
                getView()?.showLoading(false)
                getView()?.showMessage(failureMessage)
            })
        } else {
            getView()?.showMessage("Invalid Email")
        }
    }

    private fun validate(email: String) = emailValidator(email)

    private fun getView(): ILoginView? = viewReference.get()

}