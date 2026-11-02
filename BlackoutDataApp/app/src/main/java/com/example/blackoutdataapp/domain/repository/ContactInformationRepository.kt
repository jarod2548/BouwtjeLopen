package com.example.blackoutdataapp.domain.repository

import com.example.blackoutdataapp.data.local.dao.ContactInformationDoa
import com.example.blackoutdataapp.data.local.entity.ContactInformationEntity
import javax.inject.Inject

class ContactInformationRepository @Inject constructor(private val dao : ContactInformationDoa) {
    suspend fun save(entity: ContactInformationEntity){
        dao.save(entity)
    }
}