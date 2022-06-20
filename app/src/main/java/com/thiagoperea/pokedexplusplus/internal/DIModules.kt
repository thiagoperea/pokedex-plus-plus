package com.thiagoperea.pokedexplusplus.internal

import com.thiagoperea.pokedexplusplus.presentation.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { DetailsViewModel() }
}