package com.example.bazar.core.domain.local.repository

import java.lang.reflect.Type

interface IKeyValueStorageProvider {

    suspend fun <Model> save(key: IStorageLocalKey, model: Model, type: Type)
    suspend fun <Model> get(key: IStorageLocalKey, model: Model, type: Type): Model
    suspend fun <Model> update(key: IStorageLocalKey, model: Model, type: Type)
    suspend fun <Model> delete(key: IStorageLocalKey, type: Type)
    suspend fun <Model> hasKey(key: IStorageLocalKey, type: Type): Boolean

}