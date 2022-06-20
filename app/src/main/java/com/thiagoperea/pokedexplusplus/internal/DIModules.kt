package com.thiagoperea.pokedexplusplus.internal

import com.thiagoperea.pokedexplusplus.data.remote.PokeApi
import com.thiagoperea.pokedexplusplus.domain.PokemonRepository
import com.thiagoperea.pokedexplusplus.presentation.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    // api
    single {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }

    // repository
    factory { PokemonRepository(get()) }

    // viewmodels
    viewModel { DetailsViewModel(get()) }
}