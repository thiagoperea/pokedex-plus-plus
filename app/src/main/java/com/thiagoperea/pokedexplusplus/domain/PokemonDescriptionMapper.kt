package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.remote.DescriptionResponse

object PokemonDescriptionMapper {

    fun map(response: DescriptionResponse): String {

        val rawDescription = response.descriptionList.firstOrNull()?.description.orEmpty()

        return rawDescription.replace("\n", " ").replace("\\f", " ")
    }
}