package ru.artempugachev.letsmvp.github

import dagger.Component
import ru.artempugachev.letsmvp.app.ApplicationModule
import ru.artempugachev.letsmvp.login.LoginActivity
import ru.artempugachev.letsmvp.login.LoginModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, GithubModule::class])
interface GithubComponent {
    fun inject(target: GithubUsersActivity)
}