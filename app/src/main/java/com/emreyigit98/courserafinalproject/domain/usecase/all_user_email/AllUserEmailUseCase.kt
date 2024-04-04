package com.emreyigit98.courserafinalproject.domain.usecase.all_user_email

import com.emreyigit98.courserafinalproject.data.local.LittleLemonPreferences
import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonPrefRepo
import javax.inject.Inject

class AllUserEmailUseCase @Inject constructor(
    private val littleLemonPrefRepo: LittleLemonPrefRepo
) {
    fun executeAllUserEmail() = littleLemonPrefRepo.allUserEmail()

}