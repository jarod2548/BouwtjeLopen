package com.example.blackoutdataapp.domain.repository

import com.example.blackoutdataapp.data.local.dao.AiAnalyseDOA
import com.example.blackoutdataapp.data.local.entity.AiAnalyseEntity
import javax.inject.Inject

class AIAnalyseRepository @Inject constructor(private val doa : AiAnalyseDOA) {
    suspend fun save(entity : AiAnalyseEntity){
        doa.save(entity)
    }
    suspend fun get() : AiAnalyseEntity?{
        return doa.get()
    }
    suspend fun exists() : Boolean{
        return doa.exists()
    }
}