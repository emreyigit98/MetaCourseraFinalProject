package com.emreyigit98.courserafinalproject.util

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    const val BASE_URL : String = "https://raw.githubusercontent.com/"
    const val ENDPOINT : String = "Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
    val USER_EMAIL_PREFERENCES_KEY = stringPreferencesKey("userEmail")
    const val PREFERENCES_FILE_NAME : String = "lemonPreferences"
}