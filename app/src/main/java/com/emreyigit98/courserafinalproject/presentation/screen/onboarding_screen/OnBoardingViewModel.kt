package com.emreyigit98.courserafinalproject.presentation.screen.onboarding_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.courserafinalproject.domain.usecase.user_add_email.AddUserEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val addUserEmailUseCase : AddUserEmailUseCase
) : ViewModel() {

    private val _onBoardingState = MutableStateFlow(OnBoardingState())
    val onBoardingState : StateFlow<OnBoardingState> get() = _onBoardingState.asStateFlow()

    fun updateEmail(
        email : String
    ) = _onBoardingState.update { onBoardingState ->
        onBoardingState.copy(
            email = email
        )
    }
    fun updateIsError(
        isError : Boolean
    ) = _onBoardingState.update { onBoardingState ->
        onBoardingState.copy(
            isError = isError
        )
    }
    fun addUserEmail() = viewModelScope.launch {
        addUserEmailUseCase.executeUserEmailAdd(email = _onBoardingState.value.email)
    }
    fun isValidEmail(email: String): Boolean {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return email.matches(emailRegex)
    }
}