package ru.artempugachev.letsmvp.topmovies.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class TmdbApi {
    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("results")
    @Expose
    var results: List<TmdbMovie> = ArrayList<TmdbMovie>()
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
}