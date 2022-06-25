package com.thiagoperea.pokedexplusplus.presentation.pokemon_list

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.databinding.ItemPokeListBinding
import com.thiagoperea.pokedexplusplus.presentation.ColorHelper
import com.thiagoperea.pokedexplusplus.presentation.dpToPx
import com.thiagoperea.pokedexplusplus.presentation.firstUppercase

class PokemonListAdapter(
    val onPokeClick: (PokemonDetails) -> Unit
) : RecyclerView.Adapter<PokemonListViewHolder>() {

    val dataset = mutableListOf<PokemonDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokeListBinding.inflate(inflater, parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(dataset[position], onPokeClick)
    }

    override fun getItemCount() = dataset.size

    fun addPokemonList(list: List<PokemonDetails>) {
        dataset.addAll(list)
    }
}

class PokemonListViewHolder(private val binding: ItemPokeListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: PokemonDetails, onPokeClick: (PokemonDetails) -> Unit) {
        binding.root.setOnClickListener {
            onPokeClick(pokemon)
        }

        binding.id.text = "#${pokemon.id.toString().padStart(3, '0')}"
        binding.image.load(pokemon.imageUrl)
        binding.name.text = pokemon.name.firstUppercase()

        val typeColor = ColorHelper.getColorFromType(pokemon.types.first())
        val pokeColor = ContextCompat.getColor(binding.root.context, typeColor)
        val pokeColorStateList = ContextCompat.getColorStateList(binding.root.context, typeColor)

        (binding.bgUpper.background as GradientDrawable).setStroke(2.dpToPx(), pokeColor)
        binding.bgLower.backgroundTintList = pokeColorStateList
        binding.id.setTextColor(pokeColor)
    }
}