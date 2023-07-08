package com.felix.noteapp.core.data

import com.felix.noteapp.core.DataMapper
import com.felix.noteapp.core.data.local.LocalDataSource
import com.felix.noteapp.core.domain.data.Notes
import com.felix.noteapp.core.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepository @Inject constructor(private val localDataSource: LocalDataSource) : INoteRepository {

    override fun getAllNotes(): Flow<List<Notes>> {
        return localDataSource.getAllNotes().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override suspend fun insertNotes(notes: Notes)  {
        val noteEntity = DataMapper.mapDomainToEntity(notes)
        localDataSource.insertNotes(noteEntity)

    }

    override suspend fun deleteNotes(notes: Notes) {
        val noteEntity = DataMapper.mapDomainToEntity(notes)
        localDataSource.deleteNotes(noteEntity)
    }

    override suspend fun updateNotes(notes: Notes) {
        val noteEntity = DataMapper.mapDomainToEntity(notes)
        localDataSource.updateNotes(noteEntity)
    }

}