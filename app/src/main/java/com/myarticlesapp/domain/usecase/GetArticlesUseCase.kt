package com.myarticlesapp.domain.usecase

import com.myarticlesapp.domain.model.Articles
import com.myarticlesapp.domain.repository.Repository
import com.myarticlesapp.domain.usecase.base.UseCase

class GetArticlesUseCase constructor(
    private val repository: Repository
) : UseCase<List<Articles>, Any?>() {

    override suspend fun run(params: Any?): List<Articles> {
        return repository.getPosts()
    }

}