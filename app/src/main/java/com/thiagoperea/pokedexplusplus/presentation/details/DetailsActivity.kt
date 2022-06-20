package com.thiagoperea.pokedexplusplus.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thiagoperea.pokedexplusplus.databinding.ActivityDetailsBinding
import com.thiagoperea.pokedexplusplus.model.PokemonDetails
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
        }
    }

    private fun loadDetails(pokemon: PokemonDetails) {
        //TODO: THIS
    }

    private fun loadMockPokemon() {
        viewModel.loadMockPokemon()
    }
}