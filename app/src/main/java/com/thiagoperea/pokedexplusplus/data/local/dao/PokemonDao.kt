package com.thiagoperea.pokedexplusplus.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemondetails")
    fun getAll(): List<PokemonDetails>

    @Query("SELECT * FROM pokemondetails WHERE id = :pokeId LIMIT 1")
    fun getById(pokeId: Int): PokemonDetails?

    @Insert
    fun insert(pokemon: PokemonDetails)

    @Delete
    fun delete(pokemon: PokemonDetails)
}