package com.example.blackoutdataapp.di

import android.content.Context
import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import com.example.blackoutdataapp.data.local.dao.AiAnalyseDOA
import com.example.blackoutdataapp.data.local.dao.ContactInformationDoa
import com.example.blackoutdataapp.data.local.dao.PersonalInformationDoa
import com.example.blackoutdataapp.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):
            AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database"
        )
            .setDriver(AndroidSQLiteDriver())
            .build()
    }

    @Provides
    fun provideAiAnalyseDOA(
        database: AppDatabase
    ): AiAnalyseDOA {
        return database.aiAnalyseDoa()
    }
    @Provides
    fun provideContactInformationDoa(
        database: AppDatabase
    ): ContactInformationDoa {
        return database.contactInformationDoa()
    }

    @Provides
    fun providePersonalInformationDoa(
        database: AppDatabase
    ): PersonalInformationDoa {
        return database.personalInformationDoa()
    }
}
