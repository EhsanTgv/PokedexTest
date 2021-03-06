package com.taghavi.pokedextest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.taghavi.pokedextest.pokemonDetails.PokemonDetailScreen
import com.taghavi.pokedextest.pokemonList.PokemonListScreen
import com.taghavi.pokedextest.ui.theme.PokedexTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTestTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ) {
                    composable("pokemon_list_screen") {
                        PokemonListScreen(
                            navController = navController
                        )
                    }
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{pokemonId}",
                        arguments = listOf(
                            navArgument("dominantColor") { type = NavType.IntType },
                            navArgument("pokemonId") { type = NavType.StringType },
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonId = remember {
                            it.arguments?.getString("pokemonId")
                        }
                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonId = pokemonId ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}