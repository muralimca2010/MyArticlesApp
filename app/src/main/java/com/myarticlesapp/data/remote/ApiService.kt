package com.myarticlesapp.data.remote

import com.myarticlesapp.domain.model.Articles
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/category_articles")
    suspend fun getPosts(): List<Articles>
}