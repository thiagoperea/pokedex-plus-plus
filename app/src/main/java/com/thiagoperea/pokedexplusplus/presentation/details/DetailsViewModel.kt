package com.thiagoperea.pokedexplusplus.presentation.details

import android.util.Log
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

            val test = withContext(Dispatchers.IO) {
                repository.loadPokemonWithId(1)
            }

            Log.d("TESTE_THI", test.toString())
        }

    }
}