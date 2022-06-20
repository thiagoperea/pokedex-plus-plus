package com.thiagoperea.pokedexplusplus.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET("pokemon/{poke_id}")
    suspend fun getPokemonFromId(@Path("poke_id") id: Int): PokemonResponse
}