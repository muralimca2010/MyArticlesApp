package com.myarticlesapp.data.repository

import com.myarticlesapp.data.remote.ApiService
import com.myarticlesapp.domain.model.Articles
import com.myarticlesapp.domain.repository.Repository

class RepositoryImp(private val apiService: ApiService) : Repository {

    override suspend fun getPosts(): List<Articles> {
        return apiService.getPosts()
    }
}