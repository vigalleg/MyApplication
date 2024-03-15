package com.example.myapplication.io


import com.example.myapplication.io.response.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST(value = "login")
    fun postLogin(@Query(value="username")username: String, @Query(value="password")password: String):
            Call<LoginResponse>

    companion object Factory{
        private const val BASE_URL = "https://lopezgeraghty.com:8080/api/"
        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create((ApiService::class.java))
        }
    }
}