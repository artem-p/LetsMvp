package ru.artempugachev.letsmvp.topmovies.di

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.artempugachev.letsmvp.topmovies.api.TmdbService

/**
 * Provide Retrofit api interface for Tmdb
 * */
@Module
class TmdbModule {
    @Provides
    fun provideClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        // add api key to queries
        val apiKeyInterceptor = Interceptor {
            chain ->
            var request = chain.request()
            val url = request.url().newBuilder().addQueryParameter("api_key", API_KEY).build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }


        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(apiKeyInterceptor)
                .build()
    }


    @Provides
    fun provideRetrofit(baseURL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    @Provides
    fun provideApiService(): TmdbService {
        return provideRetrofit(BASE_URL, provideClient()).create(TmdbService::class.java)
    }


    companion object {
        const val BASE_URL = "http://api.themoviedb.org/3/movie/"
        const val API_KEY = "8551c026bbf22a4a386ebb5b87a5296b"
    }
}

