package com.thiagoperea.pokedexplusplus.presentation.details

import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import coil.load
import com.thiagoperea.pokedexplusplus.R
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.data.model.PokemonStat
import com.thiagoperea.pokedexplusplus.data.model.PokemonStats
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes
import com.thiagoperea.pokedexplusplus.databinding.ActivityDetailsBinding
import com.thiagoperea.pokedexplusplus.databinding.ViewPokemonTypeBinding
import com.thiagoperea.pokedexplusplus.presentation.ColorHelper
import org.koin.android.ext.android.inject

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        viewModel.loadMockPokemon()
    }

    private fun setupObservers() {
        viewModel.pokemonDetailsLiveData.observe(this) { details ->
            val pokeColor = ColorHelper.getColorFromType(details.types.first())

            loadDetails(details, pokeColor)
            loadStats(details.stats, pokeColor)
            loadTypes(details.types)
        }
    }

    private fun loadDetails(pokemon: PokemonDetails, @ColorRes pokeColor: Int) {
        val pokeColorAsColor = ContextCompat.getColor(this, pokeColor)
        val pokeColorAsDrawable = ContextCompat.getDrawable(this, pokeColor)

        window.statusBarColor = pokeColorAsColor
        binding.contentRoot.background = pokeColorAsDrawable
        binding.pokeAbout.setTextColor(pokeColorAsColor)
        binding.pokeStats.setTextColor(pokeColorAsColor)
        binding.pokeName.text = pokemon.name
        binding.pokeId.text = "#${pokemon.id.toString().padStart(3, '0')}"
        binding.pokeImg.load(pokemon.imageUrl)
        binding.pokeWeight.text = getString(R.string.weight, pokemon.weight)
        binding.pokeHeight.text = getString(R.string.height, pokemon.height)

        val pokeMoves = StringBuilder()
        pokemon.moves.forEachIndexed { index, move ->
            pokeMoves.append(move)

            if (index != pokemon.moves.lastIndex) {
                pokeMoves.append("\n")
            }
        }

        binding.pokeMoves.text = pokeMoves
        binding.pokeDescription.text = pokemon.description
    }

    private fun loadStats(stats: List<PokemonStat>, pokeColor: Int) {
        val pokeColorAsColor = ContextCompat.getColor(this, pokeColor)
        binding.pokeStatsDescHp.setTextColor(pokeColorAsColor)
        binding.pokeStatsDescAtk.setTextColor(pokeColorAsColor)
        binding.pokeStatsDescDef.setTextColor(pokeColorAsColor)
        binding.pokeStatsDescSatk.setTextColor(pokeColorAsColor)
        binding.pokeStatsDescSdef.setTextColor(pokeColorAsColor)
        binding.pokeStatsDescSpd.setTextColor(pokeColorAsColor)

        binding.pokeStatsProgressHp.setIndicatorColor(pokeColorAsColor)
        binding.pokeStatsProgressAtk.setIndicatorColor(pokeColorAsColor)
        binding.pokeStatsProgressDef.setIndicatorColor(pokeColorAsColor)
        binding.pokeStatsProgressSatk.setIndicatorColor(pokeColorAsColor)
        binding.pokeStatsProgressSdef.setIndicatorColor(pokeColorAsColor)
        binding.pokeStatsProgressSpd.setIndicatorColor(pokeColorAsColor)

        stats.forEach {
            when (it.stat) {
                PokemonStats.HP -> {
                    binding.pokeStatsValueHp.text = it.value.toString()
                    binding.pokeStatsProgressHp.progress = it.value
                }
                PokemonStats.ATK -> {
                    binding.pokeStatsValueAtk.text = it.value.toString()
                    binding.pokeStatsProgressAtk.progress = it.value
                }
                PokemonStats.DEF -> {
                    binding.pokeStatsValueDef.text = it.value.toString()
                    binding.pokeStatsProgressDef.progress = it.value
                }
                PokemonStats.SATK -> {
                    binding.pokeStatsValueSatk.text = it.value.toString()
                    binding.pokeStatsProgressSatk.progress = it.value
                }
                PokemonStats.SDEF -> {
                    binding.pokeStatsValueSdef.text = it.value.toString()
                    binding.pokeStatsProgressSdef.progress = it.value
                }
                PokemonStats.SPD -> {
                    binding.pokeStatsValueSpd.text = it.value.toString()
                    binding.pokeStatsProgressSpd.progress = it.value
                }
            }
        }
    }

    private fun loadTypes(types: List<PokemonTypes>) {
        types.forEach {
            val typeBinding =
                ViewPokemonTypeBinding.inflate(layoutInflater, binding.pokeTypes, true)
            val bgColor = ColorHelper.getColorFromType(it)
            typeBinding.root.backgroundTintList = ContextCompat.getColorStateList(this, bgColor)
            typeBinding.type.text = it.name.lowercase()
        }
    }
}