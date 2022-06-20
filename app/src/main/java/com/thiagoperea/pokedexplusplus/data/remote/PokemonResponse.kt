package com.thiagoperea.pokedexplusplus.data.remote

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val moves: List<PokemonMoveResponse>,
    val sprites: PokemonSpritesResponse,
    val stats: List<PokemonStatsResponse>,
    val types: List<PokemonTypeResponse>
)

/**
 * Move related
 */
data class PokemonMoveResponse(val move: PokemonMoveInnerResponse)

data class PokemonMoveInnerResponse(val name: String)

/**
 * Sprites related
 */
data class PokemonSpritesResponse(
    @SerializedName("front_default") val frontUrl: String,
    @SerializedName("front_shiny") val frontShinyUrl: String,
    @SerializedName("other") val otherUrls: PokemonSpritesInnerResponse
)

data class PokemonSpritesInnerResponse(
    @SerializedName("official-artwork") val officialUrl: Pair<String, PokemonOfficialSpriteResponse>
)

data class PokemonOfficialSpriteResponse(@SerializedName("front-default") val url: String)

/**
 * Stats related
 */
data class PokemonStatsResponse(
    @SerializedName("base_stat") val statValue: Int,
    @SerializedName("stat") val description: PokemonStatsInnerResponse
)

data class PokemonStatsInnerResponse(val name: String)

/**
 * Types related
 */
data class PokemonTypeResponse(
    @SerializedName("slot") val order: Int,
    val description: PokemonTypeInnerResponse
)

data class PokemonTypeInnerResponse(val name: String)