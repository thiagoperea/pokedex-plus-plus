package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.remote.DescriptionInnerResponse
import com.thiagoperea.pokedexplusplus.data.remote.DescriptionResponse
import org.junit.Assert
import org.junit.Test

class PokemonDescriptionMapperTest {

    @Test
    fun testMapWithNewLine() {
        // arrange
        val responseList = listOf(
            DescriptionInnerResponse("Description with newline\nlol")
        )
        val response = DescriptionResponse(responseList)

        // act
        val mapped = PokemonDescriptionMapper.map(response)

        // assert
        Assert.assertEquals("Description with newline lol", mapped)
    }

    @Test
    fun testMapWithSlashF() {
        // arrange
        val responseList = listOf(
            DescriptionInnerResponse("Description with\\flol")
        )
        val response = DescriptionResponse(responseList)

        // act
        val mapped = PokemonDescriptionMapper.map(response)

        // assert
        Assert.assertEquals("Description with lol", mapped)
    }

    @Test
    fun testMapWithNoReplace() {
        // arrange
        val responseList = listOf(
            DescriptionInnerResponse("Description lol")
        )
        val response = DescriptionResponse(responseList)

        // act
        val mapped = PokemonDescriptionMapper.map(response)

        // assert
        Assert.assertEquals("Description lol", mapped)
    }
}