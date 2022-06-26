package com.thiagoperea.pokedexplusplus.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class PokemonDetails(
    @PrimaryKey var id: Int,
    var name: String,
    var weight: Int,
    var height: Int,
    var imageUrl: String,
    var spriteUrl: String,
    var spriteShinyUrl: String,
    var types: List<PokemonTypes>,
    var moves: List<String>,
    var description: String,
    var stats: List<PokemonStat>
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