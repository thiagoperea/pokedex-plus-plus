package com.thiagoperea.pokedexplusplus.presentation.details

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.data.model.PokemonStat
import com.thiagoperea.pokedexplusplus.data.model.PokemonStats
import com.thiagoperea.pokedexplusplus.data.model.PokemonTypes
import com.thiagoperea.pokedexplusplus.databinding.ActivityDetailsBinding
import org.koin.android.ext.android.inject

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        loadMockPokemon()
    }

    private fun setupObservers() {
        viewModel.pokemonDetailsLiveData.observe(this) { details ->
            loadDetails(details)
            loadStats(details.stats)
            loadTypes(details.types)
        }
    }

    private fun loadDetails(pokemon: PokemonDetails) {
        binding.pokeName.text = pokemon.name
        binding.pokeId.text = "#${pokemon.id}"
        binding.pokeImg.load(pokemon.imageUrl)
        binding.pokeWeight.text = "${pokemon.weight} kg"
        binding.pokeHeight.text = "${pokemon.height} m"
        binding.pokeMoves.text = pokemon.moves.toString()
        binding.pokeDescription.text = pokemon.description
    }

    private fun loadStats(stats: List<PokemonStat>) {
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
            val textView = TextView(this)
            textView.text = it.name
            binding.pokeTypes.addView(textView)
        }
    }

    private fun loadMockPokemon() {
        viewModel.loadMockPokemon()
    }
}