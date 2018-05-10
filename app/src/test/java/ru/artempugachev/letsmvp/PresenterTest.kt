package ru.artempugachev.letsmvp

import org.junit.Before
import ru.artempugachev.letsmvp.data.User
import ru.artempugachev.letsmvp.login.LoginMvpContract
import ru.artempugachev.letsmvp.login.LoginPresenterImpl

/**
 * Test for the presenter
 * */
class PresenterTest {
    private lateinit var mockLoginModel: LoginMvpContract.Model
    private lateinit var mockView: LoginMvpContract.View
    private lateinit var presenter: LoginPresenterImpl
    private lateinit var user: User

    @Before
    fun setUp() {

    }
}