package com.thiagoperea.pokedexplusplus.presentation.pokemon_list

import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails

sealed class PokemonListState {

    object Loading : PokemonListState()

    data class Success(val result: List<PokemonDetails>) : PokemonListState()

    data class Error(val errorMessage: String?) : PokemonListState()
}