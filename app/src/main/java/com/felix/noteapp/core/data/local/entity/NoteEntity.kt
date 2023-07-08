package com.felix.noteapp.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(


    @ColumnInfo(name = "title")
    @PrimaryKey
    val title : String,

    @ColumnInfo(name = "description")
    val description : String



)
