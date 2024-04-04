package com.emreyigit98.courserafinalproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emreyigit98.courserafinalproject.presentation.screen.home_screen.HomeScreen
import com.emreyigit98.courserafinalproject.presentation.screen.onboarding_screen.OnBoardingScreen
import com.emreyigit98.courserafinalproject.presentation.screen.profile_screen.ProfileScreen
import com.emreyigit98.courserafinalproject.presentation.screen.profile_screen.ProfileViewModel

@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val userEmail = profileViewModel.userEmail.collectAsState()

    NavHost(
        navController = navHostController, startDestination = when {
            userEmail.value.isNotEmpty() -> Destination.HomeScreen.route
            else -> Destination.OnBoardingScreen.route
        }
    ) {
        composable(Destination.OnBoardingScreen.route) {
            OnBoardingScreen(
                navHostController = navHostController
            )
        }
        composable(Destination.HomeScreen.route) {
            HomeScreen(
                navHostController = navHostController
            )
        }
        composable(Destination.ProfileScreen.route) {
            ProfileScreen(
                navHostController = navHostController
            )
        }
    }
}