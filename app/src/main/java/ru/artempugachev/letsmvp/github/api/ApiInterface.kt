package ru.artempugachev.letsmvp.github.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    fun getUsers(@Query("per_page") usersPerPage: Int): Call<UserResponse>
}