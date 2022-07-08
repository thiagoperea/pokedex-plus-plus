package com.thiagoperea.pokedexplusplus.presentation.pokemon_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.pokedexplusplus.domain.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonListViewModel(val repository: PokemonRepository) : ViewModel() {

    val loadStateLiveData = MutableLiveData<PokemonListState>()
    val loadMoreStateLiveData = MutableLiveData<PokemonListState>()

    fun loadPokeList() {
        viewModelScope.launch {
            loadStateLiveData.postValue(PokemonListState.Loading)

            try {
                val pokeList = withContext(Dispatchers.IO) {
                    repository.loadInitialData()
                }

                loadStateLiveData.postValue(PokemonListState.Success(pokeList))
            } catch (error: Exception) {
                loadStateLiveData.postValue(PokemonListState.Error(error.message))
            }
        }
    }

    fun loadMore() {
        if (loadMoreStateLiveData.value is PokemonListState.Loading) {
            return
        }

        viewModelScope.launch {
            loadMoreStateLiveData.postValue(PokemonListState.Loading)

            try {
                val moreItems = withContext(Dispatchers.IO) {
                    repository.loadMore()
                }

                loadMoreStateLiveData.postValue(PokemonListState.Success(moreItems))
            } catch (error: Exception) {
                loadMoreStateLiveData.postValue(PokemonListState.Error(error.message))
            }
        }
    }
}
