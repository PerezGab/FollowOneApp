package com.example.gabbinete.followone.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val API_URL = "https://ergast.com/api/f1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .client(okHttpClient())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(API_URL)
    .build()

private fun okHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor {
            val url = it.request().url
            val lastEncodedPathSegment = url.encodedPathSegments[url.encodedPathSegments.lastIndex]
            val modifiedLastEncodedPathSegment = "$lastEncodedPathSegment.json"

            val urlJsonAppended =
                url.newBuilder().removePathSegment(url.encodedPathSegments.lastIndex)
                    .addEncodedPathSegments(modifiedLastEncodedPathSegment).build()
            val requestJsonAppended = it.request().newBuilder().url(urlJsonAppended).build()
            it.proceed(requestJsonAppended)
        }.build()
}

object ApiCall {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}