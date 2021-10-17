package com.myarticlesapp.domain.repository

import com.myarticlesapp.domain.model.Articles

interface Repository {

    suspend fun getPosts(): List<Articles>
}