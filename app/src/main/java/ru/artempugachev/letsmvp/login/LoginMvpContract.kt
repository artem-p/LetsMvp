package ru.artempugachev.letsmvp.login

import ru.artempugachev.letsmvp.data.User

interface LoginMvpContract {
    interface View {
        fun getFirstName(): String
        fun getLastName(): String

        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSavedMessage()

        fun setFirstName(firstName: String)
        fun setLastName(lastName: String)
    }


    interface Presenter {
        fun bindView(view: LoginMvpContract.View)

        fun loginButtonClicked()
        fun getCurrentUser()
    }


    interface Model {
        fun createUser(firstName: String, lastName: String)

        fun getUser(): User?
    }
}