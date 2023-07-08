package com.felix.noteapp.core.domain.usecase

import com.felix.noteapp.core.domain.data.Notes
import kotlinx.coroutines.flow.Flow

interface NoteUseCase {

    fun getAllNotes() : Flow<List<Notes>>

    suspend fun insertNotes(notes: Notes)

    suspend fun deleteNotes(notes: Notes)

    suspend fun updateNotes(notes: Notes)
}