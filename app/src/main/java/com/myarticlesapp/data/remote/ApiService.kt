package com.myarticlesapp.data.remote

import com.myarticlesapp.domain.model.Articles
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): List<Articles>
}