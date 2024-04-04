package com.emreyigit98.courserafinalproject.domain.usecase.user_add_email

import com.emreyigit98.courserafinalproject.data.local.LittleLemonPreferences
import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonPrefRepo
import javax.inject.Inject

class AddUserEmailUseCase @Inject constructor(
    private val littleLemonPrefRepo: LittleLemonPrefRepo
){
   suspend fun executeUserEmailAdd(email : String) {
        littleLemonPrefRepo.addUserEmail(email = email)
    }
}