package com.example.blackoutdataapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackoutdataapp.data.local.entity.ContactInformationEntity
import com.example.blackoutdataapp.domain.repository.ContactInformationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ContactInformationVM @Inject constructor(private val repository: ContactInformationRepository)
    : ViewModel() {
    var apotheekContact by mutableStateOf("")
    var politieContact by mutableStateOf("")
    var huisartsContact by mutableStateOf("")
    var schoolContact by mutableStateOf("")
    var werkContact by mutableStateOf("")

    fun save(){
        val data = ContactInformationEntity(
            apotheekContact = apotheekContact,
            politieContact = politieContact,
            huisartsContact = huisartsContact,
            schoolContact = schoolContact,
            werkContact = werkContact
        )
        viewModelScope.launch {
            try{
                repository.save(data)
            }catch (e : Exception){

            }
        }
    }

}