package com.myarticlesapp.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myarticlesapp.domain.model.ApiError
import com.myarticlesapp.domain.model.Articles
import com.myarticlesapp.domain.usecase.GetArticlesUseCase
import com.myarticlesapp.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel


class ArticlesViewModel constructor(private val getPostsUseCase: GetArticlesUseCase) : ViewModel() {

    val postsData = MutableLiveData<List<Articles>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getPosts() {
        showProgressbar.value = true
        getPostsUseCase.invoke(viewModelScope, null, object : UseCaseResponse<List<Articles>> {
                override fun onSuccess(result: List<Articles>) {
                    Log.i(TAG, "result: $result")
                    postsData.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private val TAG = ArticlesViewModel::class.java.name
    }

}