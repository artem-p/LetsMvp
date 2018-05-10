package ru.artempugachev.letsmvp.login

import ru.artempugachev.letsmvp.data.User
import ru.artempugachev.letsmvp.login.repository.LoginRepository

class LoginModelImpl(private val repository: LoginRepository) : LoginMvpContract.Model {
    override fun createUser(firstName: String, lastName: String) {
        repository.saveUser(User(firstName, lastName))
    }


    override fun getUser(): User? {
        return repository.getUser()
    }
}