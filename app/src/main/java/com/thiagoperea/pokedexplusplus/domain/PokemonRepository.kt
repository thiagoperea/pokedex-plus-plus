package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.data.remote.PokeApi

class PokemonRepository(private val api: PokeApi) {

    private var pokemonIdToLoad = 1
    private var pokemonCallLimit = 30

    suspend fun loadPokemonWithId(id: Int): PokemonDetails {
        val rawResponse = api.getPokemonFromId(id)

        return PokemonDetailsMapper.map(rawResponse)
    }

    suspend fun loadPokemons(): List<PokemonDetails> {
        val response = mutableListOf<PokemonDetails>()

        repeat(pokemonCallLimit) {
            val pokemon = loadPokemonWithId(pokemonIdToLoad)
            response.add(pokemon)

            pokemonIdToLoad++
        }

        return response
    }

    fun resetListCounter() {
        pokemonIdToLoad = 1
    }
}