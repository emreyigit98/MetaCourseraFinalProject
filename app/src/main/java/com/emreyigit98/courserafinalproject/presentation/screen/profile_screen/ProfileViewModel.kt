package com.emreyigit98.courserafinalproject.presentation.screen.profile_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.courserafinalproject.domain.usecase.all_user_email.AllUserEmailUseCase
import com.emreyigit98.courserafinalproject.domain.usecase.delete_user_email.DeleteUserEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val allUserEmailUseCase: AllUserEmailUseCase,
    private val deleteUserEmailUseCase: DeleteUserEmailUseCase
) : ViewModel() {

    private val _userEmail = allUserEmailUseCase.executeAllUserEmail()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = ""
        )
    val userEmail: StateFlow<String> get() = _userEmail

    fun deleteUserEmail() = viewModelScope.launch {
        deleteUserEmailUseCase.deleteUserEmail()
    }
}