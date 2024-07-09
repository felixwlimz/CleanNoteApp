package com.felix.cleannoteapp.di

import com.felix.cleannoteapp.core.domain.usecase.NoteUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.DeleteNoteUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.GetAllNotesUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.GetNoteUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.InsertNoteUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.UpdateNoteUseCase
import com.felix.cleannoteapp.core.repository.INoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: INoteRepository) : NoteUseCase {
        return NoteUseCase(
            getAllNotes = GetAllNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            getNote = GetNoteUseCase(repository),
            insertNote = InsertNoteUseCase(repository),
            updateNote = UpdateNoteUseCase(repository)
        )
    }

}