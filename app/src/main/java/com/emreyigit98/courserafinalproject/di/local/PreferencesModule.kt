package com.emreyigit98.courserafinalproject.di.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.emreyigit98.courserafinalproject.data.repo.LittleLemonPrefImpl
import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonPrefRepo
import com.emreyigit98.courserafinalproject.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context : Context) : DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
               produceNewData = { emptyPreferences() }
            ),
            produceFile = { context.preferencesDataStoreFile(Constants.PREFERENCES_FILE_NAME) }
        )
    }
    @Provides
    @Singleton
    fun provideLittleLemonPrefImpl(dataStore: DataStore<Preferences>) : LittleLemonPrefRepo {
        return LittleLemonPrefImpl(preferencesDataStore = dataStore)
    }
}