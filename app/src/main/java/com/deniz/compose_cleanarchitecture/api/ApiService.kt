package com.deniz.compose_cleanarchitecture.api

import com.deniz.compose_cleanarchitecture.api.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse
}