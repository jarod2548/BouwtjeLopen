package com.example.blackoutdataapp.data.local.dao

import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Upsert
import com.example.blackoutdataapp.data.local.entity.PersonalInformationEntity

@Dao
interface PersonalInformationDoa {
    @Upsert
    suspend fun save(data : PersonalInformationEntity)
    @Query("SELECT * FROM personal_information WHERE id = 1")
    suspend fun get() : PersonalInformationEntity?
    @Query("SELECT EXISTS(SELECT 1 FROM personal_information WHERE id = 1)")
    suspend fun exists(): Boolean
}