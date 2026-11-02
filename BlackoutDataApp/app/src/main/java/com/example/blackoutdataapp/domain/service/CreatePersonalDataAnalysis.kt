package com.example.blackoutdataapp.domain.service

import com.example.blackoutdataapp.data.local.entity.AiAnalyseEntity
import com.example.blackoutdataapp.data.local.entity.PersonalInformationEntity
import com.example.blackoutdataapp.domain.repository.AIAnalyseRepository
import com.example.blackoutdataapp.domain.repository.PersonalInformationRepository
import javax.inject.Inject

class CreatePersonalDataAnalysis @Inject constructor(private val repository: AIAnalyseRepository,
    private val informationRepository: PersonalInformationRepository)
{


    suspend fun execute() : AiAnalyseEntity?{
        val data : PersonalInformationEntity? = informationRepository.getPersonalInformation()
        if (data != null){
            val entity = analyzeData(data);
            repository.save(entity)
            return entity
        }
        return null
    }

    fun analyzeData(data : PersonalInformationEntity)
    : AiAnalyseEntity{
        // call ai center for ai analyse of data
        //deze methode aanpassen later
        val sterktes = mutableListOf<String>()
        val zwaktes = mutableListOf<String>()
        val aanbeveling : String = ""
        analyseWater(data.waterAmount, zwaktes, sterktes)
        return AiAnalyseEntity(
            1,
            sterktes = sterktes.joinToString("|"),
            zwaktes = zwaktes.joinToString("|"),
            aanbeveling = aanbeveling
        )

    }

    //Nepproces voor voorbeeld
    fun analyseWater(water : Double, zwaktes : MutableList<String>, sterktes : MutableList<String>){
        if (water < 5){
            zwaktes.add("Te weinig water in huis")
        }else if(water > 10){
            sterktes.add("Genoeg water in huis")
        }
    }

}