package com.thiagoperea.pokedexplusplus.presentation.details

sealed class DetailsState {
    object Loading : DetailsState()
    data class Success(val details: String) : DetailsState()
    data class Error(val errorMessage: String?) : DetailsState()
}
