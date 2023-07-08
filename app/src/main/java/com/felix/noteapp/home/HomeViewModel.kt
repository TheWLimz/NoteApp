package com.felix.noteapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.felix.noteapp.core.domain.data.Notes
import com.felix.noteapp.core.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val noteUseCase: NoteUseCase) : ViewModel() {

    val notes = noteUseCase.getAllNotes().asLiveData()

    fun delete(note : Notes){
        viewModelScope.launch {
            noteUseCase.deleteNotes(note)
        }
    }

}