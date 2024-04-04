package com.emreyigit98.courserafinalproject.domain.usecase.delete_user_email

import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonPrefRepo
import javax.inject.Inject

class DeleteUserEmailUseCase @Inject constructor(
    private val littleLemonPrefRepo: LittleLemonPrefRepo
) {
    suspend fun deleteUserEmail() = littleLemonPrefRepo.deleteEmail()
}