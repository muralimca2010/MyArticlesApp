package com.myarticlesapp.di.module

import com.myarticlesapp.presentation.ArticlesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { ArticlesViewModel(get()) }

    single { createGetPostsUseCase(get()) }

    single { createPostRepository(get()) }
}