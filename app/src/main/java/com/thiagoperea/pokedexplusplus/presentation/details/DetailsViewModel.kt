package com.thiagoperea.pokedexplusplus.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.pokedexplusplus.domain.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel(
    val repository: PokemonRepository
) : ViewModel() {

    val pokemonDescriptionLiveData = MutableLiveData<DetailsState>()

    fun loadDescription(pokeId: Int) {
        viewModelScope.launch {
            pokemonDescriptionLiveData.postValue(DetailsState.Loading)

            try {
                val description = withContext(Dispatchers.IO){
                    repository.loadPokemonDescription(pokeId)
                }

                pokemonDescriptionLiveData.postValue(DetailsState.Success(description))
            } catch (error: Exception){
                pokemonDescriptionLiveData.postValue(DetailsState.Error(error.message))
            }
        }
    }
}