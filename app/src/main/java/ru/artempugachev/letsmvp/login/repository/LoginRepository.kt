package ru.artempugachev.letsmvp.login.repository

import ru.artempugachev.letsmvp.data.User


interface LoginRepository {
    fun getUser(): User
    fun saveUser(user: User)
}