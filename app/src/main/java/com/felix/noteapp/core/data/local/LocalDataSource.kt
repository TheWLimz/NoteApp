package com.felix.noteapp.core.data.local

import com.felix.noteapp.core.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val noteDao: NoteDao) {

    fun getAllNotes() : Flow<List<NoteEntity>>{
       return noteDao.getAllNotes()
    }

    suspend fun insertNotes(noteEntity: NoteEntity){
            noteDao.insertNotes(noteEntity)

    }

    suspend fun deleteNotes(noteEntity: NoteEntity){
            noteDao.deleteNotes(noteEntity)

    }

    suspend fun updateNotes(noteEntity: NoteEntity){
            noteDao.updateNotes(noteEntity)
    }

}