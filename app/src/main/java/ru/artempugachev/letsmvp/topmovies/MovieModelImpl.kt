package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import ru.artempugachev.letsmvp.topmovies.api.TmdbMovie

class MovieModelImpl(private val repository: Repository) : TopMoviesMvpContract.Model {
    override fun result(): Observable<MovieViewModel> {
        return Observable.zip(
                repository.getMovieData(),
                repository.getCountryData(),
                BiFunction<TmdbMovie, String, MovieViewModel> {
                    tmdbResponse: TmdbMovie, country: String ->
                    MovieViewModel(tmdbResponse.title ?: "", country)
                }
        )
    }
}