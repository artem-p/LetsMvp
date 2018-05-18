package ru.artempugachev.letsmvp.topmovies.di

import dagger.Component
import ru.artempugachev.letsmvp.app.ApplicationModule
import ru.artempugachev.letsmvp.topmovies.TopMoviesActivity
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class,
    TmdbModule::class,
    OmdbModule::class,
    TopMoviesModule::class])


interface TopMoviesComponent {
    fun inject(target: TopMoviesActivity)
}