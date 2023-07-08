package com.felix.noteapp.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.noteapp.core.domain.data.Notes
import com.felix.noteapp.core.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNotesViewModel @Inject constructor(private val noteUseCase: NoteUseCase) : ViewModel() {


    fun insert(note : Notes) {
        viewModelScope.launch{
            noteUseCase.insertNotes(note)
        }
    }

    fun update(note: Notes){
        viewModelScope.launch {
            noteUseCase.deleteNotes(note)
        }
    }


}