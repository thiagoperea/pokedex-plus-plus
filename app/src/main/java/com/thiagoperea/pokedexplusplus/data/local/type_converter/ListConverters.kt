package com.thiagoperea.pokedexplusplus.data.local.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import com.thiagoperea.pokedexplusplus.data.model.PokemonStat
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes

class ListConverters {

    private val gson = Gson()

    /* List<String> */

    @TypeConverter
    fun jsonToListString(input: String): List<String> {
        return gson.fromJson(input, object : TypeToken<List<String>>() {}.type)
    }

    @TypeConverter
    fun listStringToJson(input: List<String>): String {
        return gson.toJson(input)
    }

    /* List<PokemonTypes */

    @TypeConverter
    fun jsonToListPokemonTypes(input: String): List<PokemonTypes> {
        return gson.fromJson(input, object : TypeToken<List<PokemonTypes>>() {}.type)
    }

    @TypeConverter
    fun listPokemonTypesToJson(input: List<PokemonTypes>): String {
        return gson.toJson(input)
    }

    /* List<PokemonStat */

    @TypeConverter
    fun jsonToListPokemonStat(input: String): List<PokemonStat> {
        return gson.fromJson(input, object : TypeToken<List<PokemonStat>>() {}.type)
    }

    @TypeConverter
    fun listPokemonStatToJson(input: List<PokemonStat>): String {
        return gson.toJson(input)
    }
}