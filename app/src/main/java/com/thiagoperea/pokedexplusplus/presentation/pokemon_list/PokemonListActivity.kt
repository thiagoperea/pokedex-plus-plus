package com.thiagoperea.pokedexplusplus.presentation.pokemon_list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.thiagoperea.pokedexplusplus.R
import com.thiagoperea.pokedexplusplus.data.model.PokemonDetails
import com.thiagoperea.pokedexplusplus.databinding.ActivityPokemonListBinding
import com.thiagoperea.pokedexplusplus.internal.extension.gone
import com.thiagoperea.pokedexplusplus.internal.extension.setErrorStyle
import com.thiagoperea.pokedexplusplus.internal.extension.visible
import com.thiagoperea.pokedexplusplus.presentation.details.DetailsActivity
import org.koin.android.ext.android.inject


class PokemonListActivity : AppCompatActivity() {

    private val viewModel: PokemonListViewModel by inject()

    private lateinit var binding: ActivityPokemonListBinding
    private lateinit var adapter: PokemonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: IME ACTION SEARCH!
        setupSearch()
        setupList()
        setupViewModel()

        viewModel.loadPokeList()
    }

    private fun setupSearch() {
        binding.searchBar.doAfterTextChanged { query ->
            adapter.filterBy(query.toString())
        }
    }

    private fun setupViewModel() {
        viewModel.loadStateLiveData.observe(this) { state ->
            when (state) {
                is PokemonListState.Loading -> showLoading()
                is PokemonListState.Success -> showResponse(state.result)
                is PokemonListState.Error -> showError(state.errorMessage)
            }
        }

        viewModel.loadMoreStateLiveData.observe(this) { state ->
            when (state) {
                is PokemonListState.Loading -> showLoadingMore()
                is PokemonListState.Success -> showResponse(state.result)
                is PokemonListState.Error -> showError(state.errorMessage)
            }
        }
    }

    private fun showResponse(result: List<PokemonDetails>) {
        hideLoading()
        hideLoadingMore()
        adapter.addPokemonList(result)
    }

    private fun showError(errorMessage: String?) {
        hideLoading()
        hideLoadingMore()
        Snackbar.make(binding.root, getString(R.string.error_message, errorMessage), Snackbar.LENGTH_LONG)
            .setErrorStyle()
            .show()
    }

    private fun showLoading() {
        binding.pokeList.gone()
        binding.loading.visible()
    }

    private fun showLoadingMore() {
        binding.pokeList.scrollToPosition(adapter.itemCount - 1)
        binding.loadingBottom.visible()
    }

    private fun hideLoading() {
        binding.loading.gone()
        binding.pokeList.visible()
    }

    private fun hideLoadingMore() {
        binding.loadingBottom.gone()
    }

    private fun setupList() {
        adapter = PokemonListAdapter { poke ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.EXTRA_POKE_DETAILS, poke)
            startActivity(intent)
        }

        binding.pokeList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@PokemonListActivity, 3, GridLayoutManager.VERTICAL, false)
            adapter = this@PokemonListActivity.adapter

            addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (!recyclerView.canScrollVertically(1) && !this@PokemonListActivity.adapter.isFiltering()) {
                        viewModel.loadMore()
                    }

                    super.onScrolled(recyclerView, dx, dy)
                }
            })
        }
    }
}