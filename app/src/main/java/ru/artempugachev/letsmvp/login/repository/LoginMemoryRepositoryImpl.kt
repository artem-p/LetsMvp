package ru.artempugachev.letsmvp.login.repository

import ru.artempugachev.letsmvp.data.User

class LoginMemoryRepositoryImpl : LoginRepository {
    private var user: User? = null

    override fun getUser(): User {
        var outputUser = User("John", "Smith")
        outputUser.setId(0)

        if (this.user != null) {
            this.user?.let { user -> outputUser = user }
        }

        return outputUser
    }


    override fun saveUser(user: User) {
        this.user = user
    }
}