package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable
import ru.artempugachev.letsmvp.topmovies.api.MovieDbResponse

interface Repository {
    fun getMoviesFromMemory(): Observable<MovieDbResponse>

    fun getMoviesFromNetwork(): Observable<MovieDbResponse>

    fun getCountriesFromMemory(): Observable<String>

    fun getCountriesFromNetwork(): Observable<String>

    fun getCountryData(): Observable<String>

    fun getMovieData(): Observable<MovieDbResponse>
}
