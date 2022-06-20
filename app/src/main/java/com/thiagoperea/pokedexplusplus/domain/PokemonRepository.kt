package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.remote.PokeApi
import com.thiagoperea.pokedexplusplus.data.remote.PokemonResponse

class PokemonRepository(private val api: PokeApi) {

    suspend fun loadPokemonWithId(id: Int): PokemonResponse {
        return api.getPokemonFromId(id)
    }


}