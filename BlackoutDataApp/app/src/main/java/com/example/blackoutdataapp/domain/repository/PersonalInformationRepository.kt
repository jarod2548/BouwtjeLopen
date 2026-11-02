package com.example.blackoutdataapp.domain.repository

import com.example.blackoutdataapp.data.local.dao.PersonalInformationDoa
import com.example.blackoutdataapp.data.local.entity.PersonalInformationEntity
import javax.inject.Inject

class PersonalInformationRepository @Inject constructor(private val dao : PersonalInformationDoa){
    suspend fun getPersonalInformation() : PersonalInformationEntity?{
        return dao.get()
    }
    suspend fun save(entity: PersonalInformationEntity){
        dao.save(entity)
    }
    suspend fun exists(): Boolean{
        return dao.exists()
    }
}
