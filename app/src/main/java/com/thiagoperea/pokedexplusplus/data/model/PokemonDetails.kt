package com.thiagoperea.pokedexplusplus.data.model

data class PokemonDetails(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val imageUrl: String,
    val spriteUrl: String,
    val spriteShinyUrl: String,
    val types: List<PokemonTypes>,
    val moves: List<String>,
    val description: String,
    val stats: List<PokemonStat>
)

enum class PokemonTypes {
    BUG,
    ELECTRIC,
    FIRE,
    FLYING,
    GHOST,
    GRASS,
    NORMAL,
    POISON,
    PSYCHIC,
    ROCK,
    WATER
}

data class PokemonStat(val stat: PokemonStats, val value: Int)

enum class PokemonStats {
    HP,
    ATK,
    DEF,
    SATK,
    SDEF,
    SPD
}