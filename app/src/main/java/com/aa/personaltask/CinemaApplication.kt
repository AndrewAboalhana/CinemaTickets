package com.aa.personaltask

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aa.personaltask.screens.booking_screen.BookingScreen
import com.aa.personaltask.screens.home_screen.HomeScreen
import com.aa.personaltask.screens.movie_details.MovieDetailsScreen
import com.aa.personaltask.ui.theme.PersonalTaskTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaApplication() {
    PersonalTaskTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home screen") {
                composable("home screen") { HomeScreen(navController) }
                composable("movie screen") { MovieDetailsScreen(navController) }
                composable("booking screen") { BookingScreen(navController) }
            }
    }
}