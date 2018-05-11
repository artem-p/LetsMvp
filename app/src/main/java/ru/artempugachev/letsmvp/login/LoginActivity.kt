package ru.artempugachev.letsmvp.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ru.artempugachev.letsmvp.R
import ru.artempugachev.letsmvp.app.LetsMvpApp
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginMvpContract.View {

    @Inject
    lateinit var presenter: LoginMvpContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as LetsMvpApp).getApplicationComponent().inject(this)

        buttonLogin.setOnClickListener { presenter.saveUser() }
    }


    override fun onResume() {
        super.onResume()

        presenter.bindView(this)
        presenter.getCurrentUser()
    }


    override fun getFirstName(): String {
        return editTextFirstName.text.toString()
    }

    override fun getLastName(): String {
        return editTextLastName.text.toString()
    }

    override fun showUserNotAvailable() {
        // we can use Snackbar or whatever implementation
        // the presenter doesn't care what the actual implementation is
        Toast.makeText(this, "User not available", Toast.LENGTH_SHORT).show()
    }

    override fun showInputError() {
        Toast.makeText(this, "First name or last name cannot be empty", Toast.LENGTH_SHORT).show()
    }

    override fun showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show()
    }

    override fun setFirstName(firstName: String) {
        editTextFirstName.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        editTextLastName.setText(lastName)
    }

}
