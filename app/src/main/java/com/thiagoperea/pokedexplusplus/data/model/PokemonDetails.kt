package com.thiagoperea.pokedexplusplus.data.model

data class PokemonDetails(
    val id: Int,
    val name: String,
    val weight: String,
    val height: String,
    val imageUrl: String,
    val spriteUrl: String,
    val spriteShinyUrl: String,
    val types: List<PokemonType>,
    val moves: List<String>,
    val description: String,
    val stats: List<PokemonStat>
)

enum class PokemonType

data class PokemonStat(val description: String, val value: Int)
