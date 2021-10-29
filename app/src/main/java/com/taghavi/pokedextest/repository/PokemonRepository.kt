package com.taghavi.pokedextest.repository

import com.taghavi.pokedextest.data.remote.PokeApi
import com.taghavi.pokedextest.data.remote.responses.Pokemon
import com.taghavi.pokedextest.data.remote.responses.PokemonList
import com.taghavi.pokedextest.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonId: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonId)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }

        return Resource.Success(response)
    }
}