package com.felix.noteapp.core.domain.repository

import com.felix.noteapp.core.data.local.entity.NoteEntity
import com.felix.noteapp.core.domain.data.Notes
import kotlinx.coroutines.flow.Flow

interface INoteRepository {

    fun getAllNotes() : Flow<List<Notes>>

    suspend fun insertNotes(notes: Notes)

    suspend fun deleteNotes(notes: Notes)

    suspend fun updateNotes(notes: Notes)

}