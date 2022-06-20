package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.data.model.PokemonStat
import com.thiagoperea.pokedexplusplus.data.model.PokemonStats
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes
import com.thiagoperea.pokedexplusplus.data.remote.PokemonResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonStatsResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonTypeResponse
import java.util.*

object PokemonDetailsMapper {

    fun map(response: PokemonResponse): PokemonDetails {

        val imageUrl = response.sprites.otherUrls.officialUrl.url
        val spriteUrl = response.sprites.frontUrl
        val spriteShinyUrl = response.sprites.frontShinyUrl

        val types = getTypesList(response.types)

        val moves = response.moves.take(2).map { it.move.name }

        val stats = getStatsList(response.stats)

        return PokemonDetails(
            response.id,
            response.name,
            response.weight,
            response.height,
            imageUrl,
            spriteUrl,
            spriteShinyUrl,
            types,
            moves,
            "I NEED TO USE ANOTHER API :(",
            stats
        )
    }

    private fun getStatsList(stats: List<PokemonStatsResponse>): List<PokemonStat> {
        val pokemonStats = mutableListOf<PokemonStat>()

        stats.forEach {
            val stat = when (it.description.name.lowercase(Locale.getDefault())) {
                "hp" -> PokemonStats.HP
                "attack" -> PokemonStats.ATK
                "defense" -> PokemonStats.DEF
                "special-attack" -> PokemonStats.SATK
                "special-defense" -> PokemonStats.SDEF
                "speed" -> PokemonStats.SPD
                else -> throw UnsupportedOperationException("STAT NOT MAPPED: ${it.description}")
            }

            pokemonStats.add(PokemonStat(stat, it.statValue))
        }

        return pokemonStats
    }

    private fun getTypesList(types: List<PokemonTypeResponse>): List<PokemonTypes> {
        val pokemonTypes = mutableListOf<PokemonTypes>()

        types.sortedBy { it.order }
            .forEach { type ->
                val pokemonType = when (type.description.name.lowercase(Locale.getDefault())) {
                    "bug" -> PokemonTypes.BUG
                    "electric" -> PokemonTypes.ELECTRIC
                    "fire" -> PokemonTypes.FIRE
                    "flying" -> PokemonTypes.FLYING
                    "ghost" -> PokemonTypes.GHOST
                    "grass" -> PokemonTypes.GRASS
                    "normal" -> PokemonTypes.NORMAL
                    "poison" -> PokemonTypes.POISON
                    "psychic" -> PokemonTypes.PSYCHIC
                    "rock" -> PokemonTypes.ROCK
                    "water" -> PokemonTypes.WATER
                    else -> throw UnsupportedOperationException("TYPE NOT MAPPED: ${type.description}")
                }

                pokemonTypes.add(pokemonType)
            }

        return pokemonTypes
    }

}