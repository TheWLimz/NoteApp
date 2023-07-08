package com.felix.noteapp.core.di

import com.felix.noteapp.core.data.NoteRepository
import com.felix.noteapp.core.domain.repository.INoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: NoteRepository) : INoteRepository

}