package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.details.DetailScreen
import com.example.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            //pass where should us lead to
            HomeScreen(navController = navController)
        }

        composable(
            MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) { backStackEntry ->
            //pass where should us lead to
            DetailScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}