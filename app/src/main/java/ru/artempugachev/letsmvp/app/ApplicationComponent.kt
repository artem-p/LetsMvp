package ru.artempugachev.letsmvp.app

import dagger.Component
import ru.artempugachev.letsmvp.login.LoginActivity
import ru.artempugachev.letsmvp.login.LoginModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LoginModule::class])
interface ApplicationComponent {
    fun inject(target: LoginActivity)
}