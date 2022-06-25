package com.thiagoperea.pokedexplusplus.presentation

import com.thiagoperea.pokedexplusplus.R
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.BUG
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.DARK
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.DRAGON
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.ELECTRIC
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.FAIRY
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.FIGHTING
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.FIRE
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.FLYING
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.GHOST
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.GRASS
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.GROUND
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.ICE
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.NORMAL
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.POISON
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.PSYCHIC
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.ROCK
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.STEEL
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes.WATER

object ColorHelper {

    fun getColorFromType(type: PokemonTypes) = when (type) {
        BUG -> R.color.bug
        DARK -> R.color.dark
        DRAGON -> R.color.dragon
        ELECTRIC -> R.color.electric
        FAIRY -> R.color.fairy
        FIGHTING -> R.color.fighting
        FIRE -> R.color.fire
        FLYING -> R.color.flying
        GHOST -> R.color.ghost
        GRASS -> R.color.grass
        GROUND -> R.color.ground
        ICE -> R.color.ice
        NORMAL -> R.color.normal
        POISON -> R.color.poison
        PSYCHIC -> R.color.psychic
        ROCK -> R.color.rock
        STEEL -> R.color.steel
        WATER -> R.color.water
    }
}