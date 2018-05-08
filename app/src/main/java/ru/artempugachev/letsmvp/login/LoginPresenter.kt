package ru.artempugachev.letsmvp.login

class LoginPresenter(private val model: LoginMvpContract.Model) : LoginMvpContract.Presenter {
    private var view: LoginMvpContract.View? = null


    override fun bindView(view: LoginMvpContract.View) {
        this.view = view
    }


    override fun loginButtonClicked() {
        if (view?.getFirstName().isNullOrEmpty() || view?.getLastName().isNullOrEmpty()) {
            // empty first or last name, show error
            view?.showInputError()
        } else {
            // save the user
            view?.let { view -> model.createUser(view.getFirstName(), view.getLastName()) }
            view?.showUserSavedMessage()
        }
    }


    override fun getCurrentUser() {
        val user = model.getUser()

        if (user == null) {
            view?.showUserNotAvailable()
        } else {
            view?.setFirstName(user.firstName)
            view?.setLastName(user.lastName)
        }
    }
}