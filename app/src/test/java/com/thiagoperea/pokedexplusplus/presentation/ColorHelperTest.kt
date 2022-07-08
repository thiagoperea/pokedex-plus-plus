package com.thiagoperea.pokedexplusplus.presentation

import com.thiagoperea.pokedexplusplus.R
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes
import org.junit.Assert.assertEquals
import org.junit.Test

class ColorHelperTest {

    @Test
    fun testgetColorFromType() {
        // arrange
        // act
        val bug = ColorHelper.getColorFromType(PokemonTypes.BUG)
        val dark = ColorHelper.getColorFromType(PokemonTypes.DARK)
        val dragon = ColorHelper.getColorFromType(PokemonTypes.DRAGON)
        val electric = ColorHelper.getColorFromType(PokemonTypes.ELECTRIC)
        val fairy = ColorHelper.getColorFromType(PokemonTypes.FAIRY)
        val fighting = ColorHelper.getColorFromType(PokemonTypes.FIGHTING)
        val fire = ColorHelper.getColorFromType(PokemonTypes.FIRE)
        val flying = ColorHelper.getColorFromType(PokemonTypes.FLYING)
        val ghost = ColorHelper.getColorFromType(PokemonTypes.GHOST)
        val grass = ColorHelper.getColorFromType(PokemonTypes.GRASS)
        val ground = ColorHelper.getColorFromType(PokemonTypes.GROUND)
        val ice = ColorHelper.getColorFromType(PokemonTypes.ICE)
        val normal = ColorHelper.getColorFromType(PokemonTypes.NORMAL)
        val poison = ColorHelper.getColorFromType(PokemonTypes.POISON)
        val psychic = ColorHelper.getColorFromType(PokemonTypes.PSYCHIC)
        val rock = ColorHelper.getColorFromType(PokemonTypes.ROCK)
        val steel = ColorHelper.getColorFromType(PokemonTypes.STEEL)
        val water = ColorHelper.getColorFromType(PokemonTypes.WATER)

        // assert
        assertEquals(bug, R.color.bug)
        assertEquals(dark, R.color.dark)
        assertEquals(dragon, R.color.dragon)
        assertEquals(electric, R.color.electric)
        assertEquals(fairy, R.color.fairy)
        assertEquals(fighting, R.color.fighting)
        assertEquals(fire, R.color.fire)
        assertEquals(flying, R.color.flying)
        assertEquals(ghost, R.color.ghost)
        assertEquals(grass, R.color.grass)
        assertEquals(ground, R.color.ground)
        assertEquals(ice, R.color.ice)
        assertEquals(normal, R.color.normal)
        assertEquals(poison, R.color.poison)
        assertEquals(psychic, R.color.psychic)
        assertEquals(rock, R.color.rock)
        assertEquals(steel, R.color.steel)
        assertEquals(water, R.color.water)

    }
}