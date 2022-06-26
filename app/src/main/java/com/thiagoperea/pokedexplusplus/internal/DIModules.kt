package com.thiagoperea.pokedexplusplus.internal

import androidx.room.Room
import com.thiagoperea.pokedexplusplus.data.local.PokedexDatabase
import com.thiagoperea.pokedexplusplus.data.remote.PokeApi
import com.thiagoperea.pokedexplusplus.domain.PokemonRepository
import com.thiagoperea.pokedexplusplus.presentation.details.DetailsViewModel
import com.thiagoperea.pokedexplusplus.presentation.pokemon_list.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL_API = "https://pokeapi.co/api/v2/"
const val DATABASE_NAME = "pokedex.db"

val appModule = module {

    // api
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }

    // databaase
    single {
        Room.databaseBuilder(
            get(),
            PokedexDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<PokedexDatabase>().pokemonDao() }

    // repository
    factory { PokemonRepository(get(), get()) }

    // viewmodels
    viewModel { DetailsViewModel(get()) }
    viewModel { PokemonListViewModel(get()) }
}