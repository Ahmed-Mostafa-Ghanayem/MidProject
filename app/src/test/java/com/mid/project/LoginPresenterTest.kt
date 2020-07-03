package com.mid.project

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class LoginPresenterTest {

    @MockK
    private lateinit var view: ILoginView
    private lateinit var model: ILoginModel
    private lateinit var classUnderTest: LoginPresenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        model = object : ILoginModel {
            override fun login(
                email: String,
                password: String,
                successAction: (String) -> Unit,
                failureAction: (String) -> Unit
            ) {
                if (email == "x@y.com" && password == "123456") {
                    successAction("Success")
                } else {
                    failureAction("Fail")
                }
            }
        }
        classUnderTest = LoginPresenter(view, model, createEmailValidator())
    }

    @Test
    fun testValidateAndLoginWithValidEmailAndPasswordShouldSuccess() {
        classUnderTest.validateAndLogin("x@y.com", "123456")
        verify(exactly = 1) {
            view.showLoading(true)
        }
        verify(exactly = 1) {
            view.showLoading(false)
        }
        verify(exactly = 1) {
            view.showMessage("Success")
        }
    }

    @Test
    fun testValidateAndLoginWithValidEmailShouldFail() {
        classUnderTest.validateAndLogin("a@b.com", "123456")
        verify(exactly = 1) {
            view.showLoading(true)
        }
        verify(exactly = 1) {
            view.showLoading(false)
        }
        verify(exactly = 1) {
            view.showMessage("Fail")
        }

    }

    @Test
    fun testValidateAndLoginWithInvalidEmailShouldFailWithValidationError() {
        classUnderTest.validateAndLogin("", "123456")
        verify(exactly = 1) {
            view.showMessage("Invalid Email")
        }

    }
}