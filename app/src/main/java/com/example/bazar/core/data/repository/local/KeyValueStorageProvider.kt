package com.example.bazar.core.data.repository.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.bazar.core.domain.local.repository.IKeyValueStorageProvider
import com.example.bazar.core.domain.local.repository.IStorageLocalKey

import kotlinx.coroutines.flow.first
import java.lang.reflect.Type

@Suppress("UNCHECKED_CAST")
class KeyValueStorageProvider(private val context: Context) : IKeyValueStorageProvider {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = KEY_VALUE_STORAGE_NAME)

    override suspend fun <Model> save(key: IStorageLocalKey, model: Model, type: Type) {
        val preferenceKey = generatePreferenceKey<Model>(key, type)
        context.dataStore.edit {
            it[preferenceKey] = model
        }
    }

    override suspend fun <Model> get(
        key: IStorageLocalKey,
        model: Model,
        type: Type
    ): Model {
        val preferencesKey = generatePreferenceKey<Model>(key, type)
        val preferences = context.dataStore.data.first()
        return preferences[preferencesKey] ?: model
    }

    override suspend fun <Model> update(key: IStorageLocalKey, model: Model, type: Type) {
        val preferencesKey = generatePreferenceKey<Model>(key, type)
        context.dataStore.edit {
            it[preferencesKey] = model
        }
    }

    override suspend fun <Model> delete(key: IStorageLocalKey, type: Type) {
        val preferencesKey = generatePreferenceKey<Model>(key, type)
        context.dataStore.edit {
            it.remove(preferencesKey)
        }
    }

    override suspend fun <Model> hasKey(key: IStorageLocalKey, type: Type): Boolean {
        val preferencesKey = generatePreferenceKey<Model>(key, type)
        val preferences = context.dataStore.data.first()
        return preferences.contains(preferencesKey)
    }

    private fun <Model> generatePreferenceKey(key: IStorageLocalKey, type: Type)
            : Preferences.Key<Model> {
        return when (type) {
            String::class.java -> stringPreferencesKey(key.keyPreference)
            Float::class.java -> floatPreferencesKey(key.keyPreference)
            Int::class.java -> intPreferencesKey(key.keyPreference)
            Long::class.java -> longPreferencesKey(key.keyPreference)
            Boolean::class.java -> booleanPreferencesKey(key.keyPreference)
            Set::class.java -> stringPreferencesKey(key.keyPreference)
            else -> throw Exception("Unsupported type")
        } as Preferences.Key<Model>
    }

    companion object {
        private const val KEY_VALUE_STORAGE_NAME = "github_repos_data"
    }

}







