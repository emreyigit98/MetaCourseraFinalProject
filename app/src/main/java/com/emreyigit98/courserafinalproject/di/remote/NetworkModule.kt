package com.emreyigit98.courserafinalproject.di.remote

import com.emreyigit98.courserafinalproject.data.remote.api.LittleLemonApi
import com.emreyigit98.courserafinalproject.data.repo.LittleLemonImpl
import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonRepo
import com.emreyigit98.courserafinalproject.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Provides
    @Singleton
    fun provideLittleLemonApi(retrofit: Retrofit) : LittleLemonApi {
        return retrofit.create(LittleLemonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLittleLemonImpl(littleLemonApi: LittleLemonApi) : LittleLemonRepo {
        return LittleLemonImpl(littleLemonApi = littleLemonApi)
    }

}