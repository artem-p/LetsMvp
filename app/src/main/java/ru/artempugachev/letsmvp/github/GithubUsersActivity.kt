package ru.artempugachev.letsmvp.github

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.artempugachev.letsmvp.R
import ru.artempugachev.letsmvp.app.LetsMvpApp

class GithubUsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_users)

        (application as LetsMvpApp).getGithubComponent().inject(this)
    }
}
