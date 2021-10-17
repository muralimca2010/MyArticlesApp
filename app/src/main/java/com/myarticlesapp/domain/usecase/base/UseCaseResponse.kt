package com.myarticlesapp.domain.usecase.base

import com.myarticlesapp.domain.model.ApiError

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}

