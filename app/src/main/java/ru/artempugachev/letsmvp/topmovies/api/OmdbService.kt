package ru.artempugachev.letsmvp.topmovies.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface OmdbService {
    @GET("/")
    fun getCountry(@Query("t") title: String): Observable<OmdbResponse>
}