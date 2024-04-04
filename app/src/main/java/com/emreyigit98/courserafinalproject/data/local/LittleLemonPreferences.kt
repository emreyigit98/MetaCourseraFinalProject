package com.emreyigit98.courserafinalproject.data.local

import kotlinx.coroutines.flow.Flow

interface LittleLemonPreferences {

    suspend fun addUserEmail(email : String)

    fun allUserEmail() : Flow<String>

    suspend fun deleteUserEmail()
}