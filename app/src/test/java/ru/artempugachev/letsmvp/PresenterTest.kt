package ru.artempugachev.letsmvp

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
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
        mockLoginModel = mock(LoginMvpContract.Model::class.java)

        user = User("John", "Smith")



        mockView = mock(LoginMvpContract.View::class.java)

        presenter = LoginPresenterImpl(mockLoginModel)

        presenter.bindView(mockView)
    }


    @Test
    fun shouldShowUserWhenValidUserIsPresent() {
        `when`(mockLoginModel.getUser()).thenReturn(user)

        presenter.getCurrentUser()

        // verify getting user from model
        verify(mockLoginModel, times(1)).getUser()

        // verify updating ui
        // verify methods for setting name called exact one time
        // and not calling method showUserNotAvailable
        // That is to say - when an actual user object is found - the ui should be updated
        // and no error should be shown
        verify(mockView, times(1)).setFirstName("John")
        verify(mockView, times(1)).setLastName("Smith")
        verify(mockView, never()).showUserNotAvailable()
    }


    @Test
    fun shouldShowErrorMessageWhenUserIsNull() {
        `when`(mockLoginModel.getUser()).thenReturn(null)

        presenter.getCurrentUser()

        // verify getting user from model
        verify(mockLoginModel, times(1)).getUser()

        verify(mockView, never()).setFirstName("John")
        verify(mockView, never()).setLastName("Smith")
        verify(mockView, times(1)).showUserNotAvailable()
    }


    @Test
    fun showErrorMessageIfNameFieldsAreEmpty() {
        `when`(mockView.getFirstName()).thenReturn("")

        presenter.saveUser()

        verify(mockView, times(1)).getFirstName()
        verify(mockView, never()).getLastName()
        verify(mockView, times(1)).showInputError()
    }
}