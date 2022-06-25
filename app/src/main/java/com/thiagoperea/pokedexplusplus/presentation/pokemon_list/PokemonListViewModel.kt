package com.thiagoperea.pokedexplusplus.presentation.pokemon_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.pokedexplusplus.domain.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonListViewModel(val repository: PokemonRepository) : ViewModel() {

    val loadingStateLiveData = MutableLiveData<PokemonListState>()

    init {
        repository.resetListCounter()
    }

    fun loadPokeList() {
        viewModelScope.launch {
            loadingStateLiveData.postValue(PokemonListState.Loading)

            try {
                val pokeList = withContext(Dispatchers.IO) {
                    repository.loadAllPokemons()
                }

                loadingStateLiveData.postValue(PokemonListState.Success(pokeList))
            } catch (error: Exception) {
                loadingStateLiveData.postValue(PokemonListState.Error(error.message))
            }
        }
    }
}
