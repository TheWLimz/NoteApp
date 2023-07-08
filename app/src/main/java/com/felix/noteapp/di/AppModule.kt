package com.felix.noteapp.di

import com.felix.noteapp.core.domain.usecase.NoteInteractor
import com.felix.noteapp.core.domain.usecase.NoteUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideUseCase(noteInteractor: NoteInteractor) : NoteUseCase
}