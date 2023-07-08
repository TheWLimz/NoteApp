package com.felix.noteapp.core.domain.usecase

import com.felix.noteapp.core.domain.data.Notes
import com.felix.noteapp.core.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteInteractor @Inject constructor(private val repository: INoteRepository) : NoteUseCase {

    override fun getAllNotes(): Flow<List<Notes>> {
        return repository.getAllNotes()
    }

    override suspend fun insertNotes(notes: Notes) {
        repository.insertNotes(notes)
    }

    override suspend fun deleteNotes(notes: Notes) {
        repository.deleteNotes(notes)
    }

    override suspend fun updateNotes(notes: Notes) {
        repository.updateNotes(notes)
    }

}