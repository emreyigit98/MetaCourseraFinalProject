package com.emreyigit98.courserafinalproject.data.repo

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonPrefRepo
import com.emreyigit98.courserafinalproject.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LittleLemonPrefImpl @Inject constructor(
    private val preferencesDataStore: DataStore<Preferences>
) : LittleLemonPrefRepo {

    override suspend fun addUserEmail(email: String) {
        preferencesDataStore.edit {preferences ->
            preferences[Constants.USER_EMAIL_PREFERENCES_KEY] = email
        }
    }

    override fun allUserEmail(): Flow<String> {
        return preferencesDataStore.data.catch {
            emit(emptyPreferences())
        }.map { preferences ->
            preferences[Constants.USER_EMAIL_PREFERENCES_KEY] ?: ""
        }
    }

    override suspend fun deleteEmail() {
        preferencesDataStore.edit { preferences ->
            preferences.remove(key = Constants.USER_EMAIL_PREFERENCES_KEY)
        }
    }
}