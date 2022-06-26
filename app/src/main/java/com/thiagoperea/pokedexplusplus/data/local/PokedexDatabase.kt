package com.thiagoperea.pokedexplusplus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.thiagoperea.pokedexplusplus.data.local.dao.PokemonDao
import com.thiagoperea.pokedexplusplus.data.local.type_converter.ListConverters
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails

@Database(entities = [PokemonDetails::class], version = 1)
@TypeConverters(ListConverters::class)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}