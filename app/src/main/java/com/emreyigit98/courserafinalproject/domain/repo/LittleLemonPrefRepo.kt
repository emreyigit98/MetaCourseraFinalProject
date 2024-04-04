package com.emreyigit98.courserafinalproject.domain.repo

import kotlinx.coroutines.flow.Flow

interface LittleLemonPrefRepo {

    suspend fun addUserEmail(email : String)

    fun allUserEmail() : Flow<String>

    suspend fun deleteEmail()
}