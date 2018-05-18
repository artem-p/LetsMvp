package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable
import ru.artempugachev.letsmvp.topmovies.api.OmdbService
import ru.artempugachev.letsmvp.topmovies.api.TmdbMovie
import ru.artempugachev.letsmvp.topmovies.api.TmdbService

class RepositoryImpl(private val tmdbService: TmdbService,
                     private val omdbService: OmdbService) : Repository {
    override fun getMoviesFromMemory(): Observable<TmdbMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMoviesFromNetwork(): Observable<TmdbMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCountriesFromMemory(): Observable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCountriesFromNetwork(): Observable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCountryData(): Observable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovieData(): Observable<TmdbMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}