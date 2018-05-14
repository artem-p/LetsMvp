package ru.artempugachev.letsmvp.github.api

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubInterface {
    @GET("users")
    fun getUsers(@Query("per_page") usersPerPage: Int): Call<List<UserResponse>>

    @GET("users")
    fun getUsersObservable(@Query("per_page") usersPerPage: Int): Observable<List<UserResponse>>
}