package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.data.remote.PokeApi

class PokemonRepository(private val api: PokeApi) {

    suspend fun loadPokemonWithId(id: Int): PokemonDetails {
        val rawResponse = api.getPokemonFromId(id)

        return PokemonDetailsMapper.map(rawResponse)
    }
}