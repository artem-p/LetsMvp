package ru.artempugachev.letsmvp.app

import dagger.Component
import ru.artempugachev.letsmvp.login.LoginActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(target: LoginActivity)
}