package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import ru.artempugachev.letsmvp.topmovies.api.MovieDbResponse

class MovieModelImpl(private val repository: Repository) : TopMoviesMvpContract.Model {
    override fun result(): Observable<MovieViewModel> {
        return Observable.zip(
                repository.getMovieData(),
                repository.getCountryData(),
                BiFunction<MovieDbResponse, String, MovieViewModel> {
                    movieDbResponse: MovieDbResponse, country: String ->
                    MovieViewModel(movieDbResponse.title ?: "", country)
                }
        )
    }
}