package com.example.blackoutdataapp.data.local.database

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import androidx.sqlite.driver.AndroidSQLiteDriver
import com.example.blackoutdataapp.data.local.dao.AiAnalyseDOA
import com.example.blackoutdataapp.data.local.dao.ContactInformationDoa
import com.example.blackoutdataapp.data.local.dao.PersonalInformationDoa
import com.example.blackoutdataapp.data.local.entity.AiAnalyseEntity
import com.example.blackoutdataapp.data.local.entity.ContactInformationEntity
import com.example.blackoutdataapp.data.local.entity.PersonalInformationEntity

@Database(entities =
    [PersonalInformationEntity::class,
        ContactInformationEntity::class,
        AiAnalyseEntity::class]
    , version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun personalInformationDoa() : PersonalInformationDoa
    abstract fun aiAnalyseDoa() : AiAnalyseDOA
    abstract fun contactInformationDoa() : ContactInformationDoa

}