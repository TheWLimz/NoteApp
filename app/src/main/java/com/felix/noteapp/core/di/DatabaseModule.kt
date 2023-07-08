package com.felix.noteapp.core.di

import android.content.Context
import androidx.room.Room
import com.felix.noteapp.core.data.local.NoteDao
import com.felix.noteapp.core.data.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context) : NoteDatabase{
        return Room.databaseBuilder(context, NoteDatabase::class.java, "Notes.db").fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideNoteDao(database: NoteDatabase) : NoteDao = database.noteDao()

}