package ru.artempugachev.letsmvp.app

import android.app.Application
import ru.artempugachev.letsmvp.login.LoginModule

class LetsMvpApp : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .loginModule(LoginModule())
                .build()
    }


    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}