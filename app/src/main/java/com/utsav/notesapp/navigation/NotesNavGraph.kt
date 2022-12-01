package com.utsav.notesapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.utsav.notesapp.presentation.home.HomeViewModel
import com.utsav.notesapp.presentation.home.MainScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = Note.HomeScreen.route
    ) {
        composable(route = Note.NotesDetails.route) {
            MainScreen(navController,HomeViewModel())
        }

        composable(route = Note.HomeScreen.route) {
            MainScreen(homeViewModel = HomeViewModel())
        }
    }
}

sealed class Note(val route: String) {
    object HomeScreen : Note("HomeScreen")
    object NotesDetails : Note(route = "NotesDetails")
}