package ru.artempugachev.letsmvp.topmovies.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {
    @GET("top_rated")
    fun getTopRatedMovies(@Query("page") page: Int): Observable<TmdbResponse>
}