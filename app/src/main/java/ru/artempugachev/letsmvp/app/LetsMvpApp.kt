package ru.artempugachev.letsmvp.app

import android.app.Application
import ru.artempugachev.letsmvp.github.DaggerGithubComponent
import ru.artempugachev.letsmvp.github.GithubComponent
import ru.artempugachev.letsmvp.github.GithubModule
import ru.artempugachev.letsmvp.login.LoginModule
import ru.artempugachev.letsmvp.topmovies.di.DaggerTopMoviesComponent
import ru.artempugachev.letsmvp.topmovies.di.TopMoviesComponent
import ru.artempugachev.letsmvp.topmovies.di.TopMoviesModule

class LetsMvpApp : Application() {
    private lateinit var applicationComponent: ApplicationComponent
    private lateinit var githubComponent: GithubComponent
    private lateinit var topMoviesComponent: TopMoviesComponent


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

        topMoviesComponent = DaggerTopMoviesComponent.builder()
                .applicationModule(ApplicationModule(this))
                .topMoviesModule(TopMoviesModule())
                .build()
    }


    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }


    fun getGithubComponent(): GithubComponent {
        return githubComponent
    }


    fun getTopMoviesComponent(): TopMoviesComponent {
        return topMoviesComponent
    }
}