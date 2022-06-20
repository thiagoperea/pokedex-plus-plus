package com.thiagoperea.pokedexplusplus.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thiagoperea.pokedexplusplus.model.PokemonDetails

class DetailsViewModel : ViewModel() {

    val pokemonDetailsLiveData = MutableLiveData<PokemonDetails>()

    fun loadMockPokemon() {

    }
}