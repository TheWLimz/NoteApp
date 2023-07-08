package com.felix.noteapp.core

import com.felix.noteapp.core.data.local.entity.NoteEntity
import com.felix.noteapp.core.domain.data.Notes

object DataMapper {

    fun mapEntitiesToDomain(notes : List<NoteEntity>) : List<Notes>{
       return notes.map { note ->
           Notes(
                description = note.description,
                title = note.title
            )
        }

    }

    fun mapDomainToEntity(note : Notes) : NoteEntity =
        NoteEntity(
            description = note.description,
            title = note.title
        )

}