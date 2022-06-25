package com.thiagoperea.pokedexplusplus.data.remote

data class PokemonListResponse(
    val results: List<PokemonListInnerResponse>
)

data class PokemonListInnerResponse(
    val name: String,
    val url: String
)