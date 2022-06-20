package com.thiagoperea.pokedexplusplus.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.domain.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel(
    val repository: PokemonRepository
) : ViewModel() {

    val pokemonDetailsLiveData = MutableLiveData<PokemonDetails>()

    fun loadMockPokemon() {
        viewModelScope.launch {

            val bulbasaur = withContext(Dispatchers.IO) {
                repository.loadPokemonWithId(1)
            }

            pokemonDetailsLiveData.postValue(bulbasaur)
        }

    }
}