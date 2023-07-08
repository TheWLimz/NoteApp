package com.felix.noteapp.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.felix.noteapp.core.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 2, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao
}