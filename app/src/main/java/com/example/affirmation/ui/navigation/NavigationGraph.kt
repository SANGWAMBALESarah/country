package com.example.affirmation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.affirmation.ui.CountryListScreen
import com.example.affirmation.ui.HomeScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("country_list") {
            CountryListScreen(navController = navController)
        }
    }
}