package com.example.blackoutdataapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackoutdataapp.data.local.entity.AiAnalyseEntity
import com.example.blackoutdataapp.domain.repository.AIAnalyseRepository
import com.example.blackoutdataapp.domain.repository.PersonalInformationRepository
import com.example.blackoutdataapp.domain.service.CreatePersonalDataAnalysis
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AiAnalysisVM @Inject constructor(
    val createPersonalData : CreatePersonalDataAnalysis,
    val aiAnalyseRepository: AIAnalyseRepository,
    val personalInformationRepository: PersonalInformationRepository
) : ViewModel() {
    val Sterktes = mutableStateListOf<String>()
    val zwaktes = mutableStateListOf<String>()

    var aanbeveling by mutableStateOf("")
        private set
    var hasSavedAiAnalyse by mutableStateOf<Boolean?>(null)
        private set

    init{
        checkIfAnalysisExists()
    }
    fun checkIfAnalysisExists() {
        viewModelScope.launch {
          hasSavedAiAnalyse =  aiAnalyseRepository.exists()
        }
    }
    suspend fun createAiAnalysis(){
        val entity = personalInformationRepository.getPersonalInformation()
        checkWater(entity?.waterAmount ?: 0.0)

    }

    suspend fun save(){
        val entity = AiAnalyseEntity(
            sterktes = Sterktes.joinToString("|"),
            zwaktes = zwaktes.joinToString("|"),
            aanbeveling = aanbeveling
        )
        aiAnalyseRepository.save(entity)
    }
    suspend fun load(){
        val entity = aiAnalyseRepository.get()
    }

    fun checkWater(water : Double){
        when{
            water > 10 -> {
                Sterktes.add("genoeg aantal water")
            }
            water < 5 -> {
                zwaktes.add("niet genoeg water")
            }
            else ->  {

            }
        }
    }

}