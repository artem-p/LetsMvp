package ru.artempugachev.letsmvp.app

import android.app.Application
import ru.artempugachev.letsmvp.DaggerApplicationComponent

class LetsMvpApp : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }


    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}