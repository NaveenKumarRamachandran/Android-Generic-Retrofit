package com.retrofit.sample.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService private constructor() {



    fun getUser(): APICallBack {
        return retrofit!!.create(APICallBack::class.java)
    }

    companion object {
        private var instance: APIService? = null
        private var retrofit: Retrofit? = null
        private lateinit var builder: Retrofit.Builder
        private const val BASE_URL = "https://reqres.in"

        @Synchronized
        fun getInstance(): APIService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            if (instance == null) {
                instance = APIService()
            }
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).client(client).build()
            }

            return instance as APIService
        }


    }

}