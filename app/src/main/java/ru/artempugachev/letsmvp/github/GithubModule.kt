package ru.artempugachev.letsmvp.github

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.artempugachev.letsmvp.github.api.GithubInterface

@Module
class GithubModule {

    /**
     * Add logging to client
     * */
    @Provides
    fun provideClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS

        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    @Provides
    fun provideApiService(): GithubInterface {
        return provideRetrofit(BASE_URL, provideClient()).create(GithubInterface::class.java)
    }
}

const val BASE_URL = "https://api.github.com"