package com.mid.project

import org.junit.Test

class LoginServiceLocatorKtTest {

    private val classUnderTest = createEmailValidator()

    @Test
    fun testCreateEmailValidatorFail() {
        assert(!classUnderTest(""))
    }
}