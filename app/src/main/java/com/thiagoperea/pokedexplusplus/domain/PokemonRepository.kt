package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.local.dao.PokemonDao
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.data.remote.PokeApi

class PokemonRepository(
    private val api: PokeApi,
    private val database: PokemonDao
) {

    private var pokemonIdToLoad = 1
    private var pokemonCallLimit = 30

    suspend fun loadInitialData(): List<PokemonDetails> {
        val response = mutableListOf<PokemonDetails>()

        val databaseData = loadPokemonsFromDatabase()

        if (databaseData.isNotEmpty()) {
            response.addAll(databaseData)
        } else {
            response.addAll(loadPokemonsFromApi())
        }

        return response
    }


    suspend fun loadMore(): List<PokemonDetails> {
        return loadPokemonsFromApi()
    }

    suspend fun loadPokemonsFromApi(): List<PokemonDetails> {
        val pokemonList = mutableListOf<PokemonDetails>()

        repeat(pokemonCallLimit) {
            val pokemon = loadPokemonWithId(pokemonIdToLoad)
            pokemonList.add(pokemon)

            pokemonIdToLoad++
        }
        return pokemonList
    }

    /**
     * Loads every pokemon from database and then configure the [pokemonIdToLoad] field;
     */
    private fun loadPokemonsFromDatabase(): List<PokemonDetails> {
        val pokemonList = database.getAll()

        if (pokemonList.isNotEmpty()) {
            pokemonIdToLoad = pokemonList.last().id + 1
        }

        return pokemonList
    }

    suspend fun loadPokemonWithId(id: Int): PokemonDetails {
        val pokemonDetails = database.getById(id)
        if (pokemonDetails != null) {
            return pokemonDetails
        }

        val rawResponse = api.getPokemonFromId(id)
        val mappedResponse = PokemonDetailsMapper.map(rawResponse)
        database.insert(mappedResponse)

        return mappedResponse
    }

    suspend fun loadPokemonDescription(pokeId: Int): String {
        val rawResponse = api.getDescription(pokeId)

        val description = PokemonDescriptionMapper.map(rawResponse)

        database.updatePokemonDetails(pokeId, description)

        return description
    }
}