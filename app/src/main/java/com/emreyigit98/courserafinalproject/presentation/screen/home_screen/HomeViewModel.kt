package com.emreyigit98.courserafinalproject.presentation.screen.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.courserafinalproject.domain.model.MenuItemModel
import com.emreyigit98.courserafinalproject.domain.usecase.get_menuitem.GetLittleLemonMenuUseCase
import com.emreyigit98.courserafinalproject.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLittleLemonMenuUseCase: GetLittleLemonMenuUseCase
) : ViewModel() {

    private val _homeState = mutableStateOf<HomeState>(HomeState())
    val homeState: State<HomeState> get() = _homeState

    init {
        getMenuItemList()
    }

    private fun getMenuItemList() {
        getLittleLemonMenuUseCase.executeAllLittleLemonList().onEach {
            when(it) {
                is Resource.Error -> {
                    _homeState.value = HomeState(error = it.message ?: "")
                }
                is Resource.Loading -> {
                    _homeState.value = HomeState(loading = true)
                }
                is Resource.Success -> {
                    _homeState.value = HomeState(foodList = it.data ?: emptyList())
                }
            }
        }.launchIn(
            scope = viewModelScope
        )
    }
    fun resetMenuItemList() = getMenuItemList()
}