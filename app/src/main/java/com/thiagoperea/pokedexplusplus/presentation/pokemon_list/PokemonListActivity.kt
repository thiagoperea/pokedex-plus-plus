package com.thiagoperea.pokedexplusplus.presentation.pokemon_list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thiagoperea.pokedexplusplus.databinding.ActivityPokemonListBinding
import com.thiagoperea.pokedexplusplus.presentation.details.DetailsActivity

class PokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val pokeId = binding.inputLayout.editText?.text.toString().toIntOrNull() ?: 50

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.EXTRA_POKE_ID, pokeId)

            startActivity(intent)
        }
    }
}