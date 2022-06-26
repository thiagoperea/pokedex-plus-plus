package com.thiagoperea.pokedexplusplus.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon/{poke_id}")
    suspend fun getPokemonFromId(@Path("poke_id") id: Int): PokemonResponse

    @GET("pokemon-species/{poke_id}")
    suspend fun getDescription(@Path("poke_id") id: Int): DescriptionResponse
}