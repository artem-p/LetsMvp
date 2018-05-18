package ru.artempugachev.letsmvp.topmovies.di

import dagger.Module
import dagger.Provides
import ru.artempugachev.letsmvp.topmovies.MovieModelImpl
import ru.artempugachev.letsmvp.topmovies.MoviePresenterImpl
import ru.artempugachev.letsmvp.topmovies.Repository
import ru.artempugachev.letsmvp.topmovies.TopMoviesMvpContract
import ru.artempugachev.letsmvp.topmovies.api.OmdbService
import ru.artempugachev.letsmvp.topmovies.api.TmdbService
import javax.inject.Singleton

@Module
class TopMoviesModule {
    @Provides
    fun providePresenter(model: TopMoviesMvpContract.Model): TopMoviesMvpContract.Presenter {
        return MoviePresenterImpl(model)
    }


    @Provides
    fun provideModel(repository: Repository): TopMoviesMvpContract.Model {
        return MovieModelImpl(repository)
    }


    @Singleton
    @Provides
    fun provideRepository(tmdbService: TmdbService, omdbService: OmdbService): Repository {
        return ru.artempugachev.letsmvp.topmovies.RepositoryImpl(tmdbService, omdbService)
    }
}