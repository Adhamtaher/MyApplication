package com.example.myapplication.common

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

open class BaseRepository {

    companion object {
        val gson = Gson()
        private val converterFactory = GsonConverterFactory.create(gson)
        private val interceptor = HttpLoggingInterceptor {
            Timber.tag("OkHttp").d(it)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)
        private val okhttpClient = OkHttpClient().newBuilder().run {
            addInterceptor(interceptor)
            connectTimeout(2, TimeUnit.MINUTES)
            readTimeout(2, TimeUnit.MINUTES)
            build()
        }
        private val retorfit = Retrofit.Builder().baseUrl("https://graceful-jay-cowboy-hat.cyclic.app")
            .addConverterFactory(converterFactory).client(okhttpClient).build()
        val service = retorfit.create(HospiService::class.java)
    }
}