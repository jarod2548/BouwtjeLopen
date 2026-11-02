package com.example.blackoutdataapp.data.local.dao

import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Upsert
import com.example.blackoutdataapp.data.local.entity.ContactInformationEntity

@Dao
interface ContactInformationDoa {
    @Query("SELECT * FROM contact_information WHERE id = 1")
    suspend fun get() : ContactInformationEntity?
    @Query("SELECT EXISTS(SELECT 1 FROM contact_information WHERE id = 1)")
    suspend fun exists(): Boolean
    @Upsert
    suspend fun save(data : ContactInformationEntity)
}