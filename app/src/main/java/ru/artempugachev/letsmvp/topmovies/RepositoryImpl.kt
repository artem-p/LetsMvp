package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable
import ru.artempugachev.letsmvp.topmovies.api.OmdbService
import ru.artempugachev.letsmvp.topmovies.api.TmdbMovie
import ru.artempugachev.letsmvp.topmovies.api.TmdbService

class RepositoryImpl(private val tmdbService: TmdbService,
                     private val omdbService: OmdbService) : Repository {

    private var lastUpdateTime = 0
    private var movies = ArrayList<TmdbMovie>()
    private var countries = ArrayList<String>()



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


    companion object {
        const val VALID_TIME = 10 * 1000    // time after cache expired
    }
}