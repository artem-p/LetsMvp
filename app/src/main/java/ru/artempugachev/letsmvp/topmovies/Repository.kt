package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable
import ru.artempugachev.letsmvp.topmovies.api.TmdbMovie

interface Repository {
    fun getMoviesFromMemory(): Observable<TmdbMovie>

    fun getMoviesFromNetwork(): Observable<TmdbMovie>

    fun getCountriesFromMemory(): Observable<String>

    fun getCountriesFromNetwork(): Observable<String>

    fun getCountryData(): Observable<String>

    fun getMovieData(): Observable<TmdbMovie>
}
