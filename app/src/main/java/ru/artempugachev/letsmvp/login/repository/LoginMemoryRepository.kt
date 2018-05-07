package ru.artempugachev.letsmvp.login.repository

import ru.artempugachev.letsmvp.data.User

class LoginMemoryRepository : LoginRepository {
    override fun getUser(): User {
        return User(-1, "", "")
    }

    override fun saveUser() {

    }
}