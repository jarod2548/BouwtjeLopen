package com.example.blackoutdataapp.data.local.dao

import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Upsert
import com.example.blackoutdataapp.data.local.entity.AiAnalyseEntity

@Dao
interface AiAnalyseDOA {
    @Upsert
    suspend fun save (data : AiAnalyseEntity)
    @Query("SELECT * FROM ai_information WHERE id = 1")
    suspend fun get() : AiAnalyseEntity?
    @Query("SELECT EXISTS(SELECT 1 FROM ai_information WHERE id = 1)")
    suspend fun exists(): Boolean
}
