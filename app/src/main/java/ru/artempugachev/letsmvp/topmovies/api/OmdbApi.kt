package ru.artempugachev.letsmvp.topmovies.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class OmdbApi {

    /**
     * @return The title
     */
    /**
     * @param title The Title
     */
    @SerializedName("Title")
    @Expose
    var title: String? = null
    /**
     * @return The year
     */
    /**
     * @param year The Year
     */
    @SerializedName("Year")
    @Expose
    var year: String? = null
    /**
     * @return The rated
     */
    /**
     * @param rated The Rated
     */
    @SerializedName("Rated")
    @Expose
    var rated: String? = null
    /**
     * @return The released
     */
    /**
     * @param released The Released
     */
    @SerializedName("Released")
    @Expose
    var released: String? = null
    /**
     * @return The runtime
     */
    /**
     * @param runtime The Runtime
     */
    @SerializedName("Runtime")
    @Expose
    var runtime: String? = null
    /**
     * @return The genre
     */
    /**
     * @param genre The Genre
     */
    @SerializedName("Genre")
    @Expose
    var genre: String? = null
    /**
     * @return The director
     */
    /**
     * @param director The Director
     */
    @SerializedName("Director")
    @Expose
    var director: String? = null
    /**
     * @return The writer
     */
    /**
     * @param writer The Writer
     */
    @SerializedName("Writer")
    @Expose
    var writer: String? = null
    /**
     * @return The actors
     */
    /**
     * @param actors The Actors
     */
    @SerializedName("Actors")
    @Expose
    var actors: String? = null
    /**
     * @return The plot
     */
    /**
     * @param plot The Plot
     */
    @SerializedName("Plot")
    @Expose
    var plot: String? = null
    /**
     * @return The language
     */
    /**
     * @param language The Language
     */
    @SerializedName("Language")
    @Expose
    var language: String? = null
    /**
     * @return The country
     */
    /**
     * @param country The Country
     */
    @SerializedName("Country")
    @Expose
    var country: String? = null
    /**
     * @return The awards
     */
    /**
     * @param awards The Awards
     */
    @SerializedName("Awards")
    @Expose
    var awards: String? = null
    /**
     * @return The poster
     */
    /**
     * @param poster The Poster
     */
    @SerializedName("Poster")
    @Expose
    var poster: String? = null
    /**
     * @return The metascore
     */
    /**
     * @param metascore The Metascore
     */
    @SerializedName("Metascore")
    @Expose
    var metascore: String? = null
    /**
     * @return The imdbRating
     */
    /**
     * @param imdbRating The imdbRating
     */
    @SerializedName("imdbRating")
    @Expose
    var imdbRating: String? = null
    /**
     * @return The imdbVotes
     */
    /**
     * @param imdbVotes The imdbVotes
     */
    @SerializedName("imdbVotes")
    @Expose
    var imdbVotes: String? = null
    /**
     * @return The imdbID
     */
    /**
     * @param imdbID The imdbID
     */
    @SerializedName("imdbID")
    @Expose
    var imdbID: String? = null
    /**
     * @return The type
     */
    /**
     * @param type The Type
     */
    @SerializedName("Type")
    @Expose
    var type: String? = null
    /**
     * @return The response
     */
    /**
     * @param response The Response
     */
    @SerializedName("Response")
    @Expose
    var response: String? = null

}