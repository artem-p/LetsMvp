package ru.artempugachev.letsmvp.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.artempugachev.letsmvp.R
import ru.artempugachev.letsmvp.app.LetsMvpApp

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as LetsMvpApp).getComponent().inject(this)
    }
}
