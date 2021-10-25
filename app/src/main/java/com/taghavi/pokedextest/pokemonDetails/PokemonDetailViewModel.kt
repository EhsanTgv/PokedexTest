package com.taghavi.pokedextest.pokemonDetails

import androidx.lifecycle.ViewModel
import com.taghavi.pokedextest.data.remote.responses.Pokemon
import com.taghavi.pokedextest.repository.PokemonRepository
import com.taghavi.pokedextest.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}