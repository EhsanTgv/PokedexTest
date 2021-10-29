package com.taghavi.pokedextest.data.remote

import com.taghavi.pokedextest.data.remote.responses.Pokemon
import com.taghavi.pokedextest.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonList

    @GET("pokemon/{id}")
    suspend fun getPokemonInfo(
        @Path("id") id: String
    ): Pokemon
}