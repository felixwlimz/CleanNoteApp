package com.felix.cleannoteapp.core.di

import com.felix.cleannoteapp.core.repository.INoteRepository
import com.felix.cleannoteapp.core.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideNoteRepository(noteRepository: NoteRepository) : INoteRepository

}