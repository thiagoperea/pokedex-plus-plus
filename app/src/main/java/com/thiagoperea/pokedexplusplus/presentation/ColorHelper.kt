package com.thiagoperea.pokedexplusplus.presentation

import com.thiagoperea.pokedexplusplus.R
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes

object ColorHelper {

    fun getColorFromType(type: PokemonTypes) = when (type) {
        PokemonTypes.BUG -> R.color.bug
        PokemonTypes.ELECTRIC -> R.color.electric
        PokemonTypes.FIRE -> R.color.fire
        PokemonTypes.FLYING -> R.color.flying
        PokemonTypes.GHOST -> R.color.ghost
        PokemonTypes.GRASS -> R.color.grass
        PokemonTypes.NORMAL -> R.color.normal
        PokemonTypes.POISON -> R.color.poison
        PokemonTypes.PSYCHIC -> R.color.psychic
        PokemonTypes.ROCK -> R.color.rock
        PokemonTypes.WATER -> R.color.water
    }
}