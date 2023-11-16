package com.example.marsphotos.ui.screens

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
//Url para la llamada de la web utilizando el retrofit xd
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService { // se defiene el servicio de retrofit para obtener las fotos
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi { //Se crea una instancia de servicio retrofit para obtener los datos de las foto
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}