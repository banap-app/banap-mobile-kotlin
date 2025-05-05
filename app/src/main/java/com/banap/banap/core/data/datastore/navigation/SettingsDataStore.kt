package com.banap.banap.core.data.datastore.navigation

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

object SettingsDataStore {
    private const val DATASTORE_NAME = "navigation_prefs"
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)
    val LAST_SCREEN_KEY = stringPreferencesKey("last_screen")
}