package com.example.reddittest.di

import com.example.reddittest.BuildConfig
import com.example.reddittest.model.repositories.MainRepository
import com.example.reddittest.network.PostsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class MainModule {

    @Provides
    fun provideMainRepository() = MainRepository()

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        val client = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor).build()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return client
    }

    @Provides
    @Singleton
    internal fun provideRetrofitClient(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.REDDIT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    }

    @Provides
    internal fun providePostssService(
        retrofit: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): PostsService = retrofit.client(okHttpClient).build().create(PostsService::class.java)
}