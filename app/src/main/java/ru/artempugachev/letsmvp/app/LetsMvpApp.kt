package ru.artempugachev.letsmvp.app

import android.app.Application
import ru.artempugachev.letsmvp.github.DaggerGithubComponent
import ru.artempugachev.letsmvp.github.GithubComponent
import ru.artempugachev.letsmvp.github.GithubModule
import ru.artempugachev.letsmvp.login.LoginModule

class LetsMvpApp : Application() {
    private lateinit var applicationComponent: ApplicationComponent
    private lateinit var githubComponent: GithubComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .loginModule(LoginModule())
                .build()

        githubComponent = DaggerGithubComponent.builder()
                .applicationModule(ApplicationModule(this))
                .githubModule(GithubModule())
                .build()
    }


    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }


    fun getGithubComponent(): GithubComponent {
        return githubComponent
    }
}