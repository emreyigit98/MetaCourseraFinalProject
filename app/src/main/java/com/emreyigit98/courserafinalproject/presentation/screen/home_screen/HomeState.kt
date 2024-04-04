package com.emreyigit98.courserafinalproject.presentation.screen.home_screen

import com.emreyigit98.courserafinalproject.domain.model.MenuItemModel

data class HomeState(
    var foodList: List<MenuItemModel> = emptyList(),
    var enabled : Boolean = false,
    var loading : Boolean = false,
    var error : String = "",
)
