package com.thiagoperea.pokedexplusplus.domain

import com.thiagoperea.pokedexplusplus.data.model.PokemonStats
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes
import com.thiagoperea.pokedexplusplus.data.remote.PokemonMoveInnerResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonMoveResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonOfficialSpriteResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonSpritesInnerResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonSpritesResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonStatsInnerResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonStatsResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonTypeInnerResponse
import com.thiagoperea.pokedexplusplus.data.remote.PokemonTypeResponse
import org.junit.Assert.assertEquals
import org.junit.Test

class PokemonDetailsMapperTest {

    @Test
    fun testMap() {
        // arrange
        val moves = listOf(
            PokemonMoveResponse(PokemonMoveInnerResponse("mov1")),
            PokemonMoveResponse(PokemonMoveInnerResponse("mov2")),
            PokemonMoveResponse(PokemonMoveInnerResponse("mov3")),
        )

        val sprites = PokemonSpritesResponse(
            "front_url",
            "front_shiny_url",
            PokemonSpritesInnerResponse(PokemonOfficialSpriteResponse("official_url"))
        )

        val response = PokemonResponse(
            123,
            "POKEPOKE",
            10,
            20,
            moves,
            sprites,
            listOf(
                PokemonStatsResponse(100, PokemonStatsInnerResponse("hp"))
            ),
            listOf(
                PokemonTypeResponse(0, PokemonTypeInnerResponse("dark"))
            )
        )

        // act
        val mappedResponse = PokemonDetailsMapper.map(response)

        // assert
        assertEquals(123, mappedResponse.id)
        assertEquals("POKEPOKE", mappedResponse.name)
        assertEquals(10, mappedResponse.weight)
        assertEquals(20, mappedResponse.height)
        assertEquals("official_url", mappedResponse.imageUrl)
        assertEquals("front_url", mappedResponse.spriteUrl)
        assertEquals("front_shiny_url", mappedResponse.spriteShinyUrl)
        assertEquals(PokemonTypes.DARK, mappedResponse.types.first())
        assertEquals(PokemonStats.HP, mappedResponse.stats.first().stat)
        assertEquals(100, mappedResponse.stats.first().value)
        assertEquals("", mappedResponse.description)
        assertEquals("mov1", mappedResponse.moves.first())
        assertEquals("mov2", mappedResponse.moves.last())
    }

    @Test
    fun testGetStatsList() {
        // arrange
        val statList = listOf(
            PokemonStatsResponse(10, PokemonStatsInnerResponse("hp")),
            PokemonStatsResponse(20, PokemonStatsInnerResponse("attack")),
            PokemonStatsResponse(30, PokemonStatsInnerResponse("defense")),
            PokemonStatsResponse(40, PokemonStatsInnerResponse("special-attack")),
            PokemonStatsResponse(50, PokemonStatsInnerResponse("special-defense")),
            PokemonStatsResponse(60, PokemonStatsInnerResponse("speed"))
        )

        // act
        val mappedList = PokemonDetailsMapper.getStatsList(statList)

        // assert
        assertEquals(10, mappedList[0].value)
        assertEquals(20, mappedList[1].value)
        assertEquals(30, mappedList[2].value)
        assertEquals(40, mappedList[3].value)
        assertEquals(50, mappedList[4].value)
        assertEquals(60, mappedList[5].value)

        assertEquals(PokemonStats.HP, mappedList[0].stat)
        assertEquals(PokemonStats.ATK, mappedList[1].stat)
        assertEquals(PokemonStats.DEF, mappedList[2].stat)
        assertEquals(PokemonStats.SATK, mappedList[3].stat)
        assertEquals(PokemonStats.SDEF, mappedList[4].stat)
        assertEquals(PokemonStats.SPD, mappedList[5].stat)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun testGetStatListUnsupported() {
        // arrange
        val statList = listOf(
            PokemonStatsResponse(0, PokemonStatsInnerResponse("unknown"))
        )
        // act
        PokemonDetailsMapper.getStatsList(statList)
    }

    @Test
    fun testGetTypesList() {
        // arrange
        val typeList = listOf(
            PokemonTypeResponse(0, PokemonTypeInnerResponse("bug")),
            PokemonTypeResponse(1, PokemonTypeInnerResponse("dark")),
            PokemonTypeResponse(2, PokemonTypeInnerResponse("dragon")),
            PokemonTypeResponse(3, PokemonTypeInnerResponse("electric")),
            PokemonTypeResponse(4, PokemonTypeInnerResponse("fairy")),
            PokemonTypeResponse(999, PokemonTypeInnerResponse("fighting")),
            PokemonTypeResponse(5, PokemonTypeInnerResponse("fire")),
            PokemonTypeResponse(6, PokemonTypeInnerResponse("flying")),
            PokemonTypeResponse(7, PokemonTypeInnerResponse("ghost")),
            PokemonTypeResponse(8, PokemonTypeInnerResponse("grass")),
            PokemonTypeResponse(9, PokemonTypeInnerResponse("ground")),
            PokemonTypeResponse(-500, PokemonTypeInnerResponse("ice")),
            PokemonTypeResponse(10, PokemonTypeInnerResponse("normal")),
            PokemonTypeResponse(11, PokemonTypeInnerResponse("poison")),
            PokemonTypeResponse(12, PokemonTypeInnerResponse("psychic")),
            PokemonTypeResponse(13, PokemonTypeInnerResponse("rock")),
            PokemonTypeResponse(14, PokemonTypeInnerResponse("steel")),
            PokemonTypeResponse(15, PokemonTypeInnerResponse("water")),
        )

        // act
        val mappedList = PokemonDetailsMapper.getTypesList(typeList)

        // assert
        assertEquals(PokemonTypes.ICE, mappedList.first())
        assertEquals(PokemonTypes.FIGHTING, mappedList.last())

        assertEquals(PokemonTypes.ICE, mappedList[0])
        assertEquals(PokemonTypes.BUG, mappedList[1])
        assertEquals(PokemonTypes.DARK, mappedList[2])
        assertEquals(PokemonTypes.DRAGON, mappedList[3])
        assertEquals(PokemonTypes.ELECTRIC, mappedList[4])
        assertEquals(PokemonTypes.FAIRY, mappedList[5])
        assertEquals(PokemonTypes.FIRE, mappedList[6])
        assertEquals(PokemonTypes.FLYING, mappedList[7])
        assertEquals(PokemonTypes.GHOST, mappedList[8])
        assertEquals(PokemonTypes.GRASS, mappedList[9])
        assertEquals(PokemonTypes.GROUND, mappedList[10])
        assertEquals(PokemonTypes.NORMAL, mappedList[11])
        assertEquals(PokemonTypes.POISON, mappedList[12])
        assertEquals(PokemonTypes.PSYCHIC, mappedList[13])
        assertEquals(PokemonTypes.ROCK, mappedList[14])
        assertEquals(PokemonTypes.STEEL, mappedList[15])
        assertEquals(PokemonTypes.WATER, mappedList[16])
        assertEquals(PokemonTypes.FIGHTING, mappedList[17])
    }

    @Test(expected = UnsupportedOperationException::class)
    fun testGetTypesListUnsupported() {
        // arrange
        val list = listOf(
            PokemonTypeResponse(0, PokemonTypeInnerResponse("unknown"))
        )
        // act
        PokemonDetailsMapper.getTypesList(list)
    }

}