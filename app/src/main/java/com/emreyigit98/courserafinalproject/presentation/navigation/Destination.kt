package com.emreyigit98.courserafinalproject.presentation.navigation

sealed class Destination(val route : String) {
    data object OnBoardingScreen : Destination("onBoarding_screen")
    data object HomeScreen : Destination("home_screen")
    data object ProfileScreen : Destination("profile_screen")
}