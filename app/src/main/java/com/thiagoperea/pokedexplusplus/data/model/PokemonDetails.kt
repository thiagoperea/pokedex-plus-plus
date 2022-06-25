package com.thiagoperea.pokedexplusplus.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
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
) : Parcelable

enum class PokemonTypes {
    BUG,
    DARK,
    DRAGON,
    ELECTRIC,
    FAIRY,
    FIGHTING,
    FIRE,
    FLYING,
    GHOST,
    GRASS,
    GROUND,
    ICE,
    NORMAL,
    POISON,
    PSYCHIC,
    ROCK,
    STEEL,
    WATER
}

@Parcelize
data class PokemonStat(val stat: PokemonStats, val value: Int) : Parcelable

enum class PokemonStats {
    HP,
    ATK,
    DEF,
    SATK,
    SDEF,
    SPD
}