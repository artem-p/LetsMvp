package ru.artempugachev.letsmvp

import android.app.Application

class LetsMvpApp : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }


    fun getComponent(): ApplicationComponent{
        return applicationComponent
    }
}