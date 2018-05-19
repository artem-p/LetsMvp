package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable
import io.reactivex.Observer
import ru.artempugachev.letsmvp.topmovies.api.*

class RepositoryImpl(private val tmdbService: TmdbService,
                     private val omdbService: OmdbService) : Repository {

    private var lastUpdateTime = System.currentTimeMillis()
    private var movies = ArrayList<TmdbMovie>()
    private var countries = ArrayList<String>()

    /**
     * Check if cache is up to date
     * */
    private fun isUpToDate(): Boolean {
          return System.currentTimeMillis() - lastUpdateTime < VALID_TIME
    }


    /**
     * Get movies from memory cache
     * */
    override fun getMoviesFromMemory(): Observable<TmdbMovie> {
        return if (isUpToDate()) {
            Observable.fromIterable(movies)
        } else {
            lastUpdateTime = System.currentTimeMillis()
            movies.clear()
            Observable.empty()
        }
    }


    /**
     * Get movies from network and save them to the cache
     * */
    override fun getMoviesFromNetwork(): Observable<TmdbMovie> {
        // concat results from 3 pages
        val topRatedMoviesObservable = tmdbService.getTopRatedMovies(1)
                .concatWith(tmdbService.getTopRatedMovies(2))
                .concatWith(tmdbService.getTopRatedMovies(3))


        // extract movies from tmdb response
        // use concatMap to preserve order
        return topRatedMoviesObservable.concatMap {
            tmdbResponse: TmdbResponse -> Observable.fromIterable(tmdbResponse.results)
        }.doOnNext {
            // save movies to cache
            // Rx call this function every time observable emit new item
            movie: TmdbMovie -> movies.add(movie)
        }
    }


    /**
     * Get countries from memory cache
     * */
    override fun getCountriesFromMemory(): Observable<String> {
        return if (isUpToDate()) {
            Observable.fromIterable(countries)
        } else {
            lastUpdateTime = System.currentTimeMillis()
            countries.clear()
            Observable.empty()
        }
    }


    /**
     * Get countries from the network and save them to the memory cache
     * */
    override fun getCountriesFromNetwork(): Observable<String?> {
        // First get movie
        // Then get country for this movie in another query

        return getMoviesFromNetwork().concatMap { tmdbMovie: TmdbMovie ->
            val title = tmdbMovie.title

            if (title != null) {
                omdbService.getCountry(title)
            } else {
                // don't know how to do it proper atm
                omdbService.getCountry("")
            }

        }.concatMap { omdbResponse: OmdbResponse ->
            Observable.just(omdbResponse.country)
        }.doOnNext { country: String -> countries.add(country) }
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