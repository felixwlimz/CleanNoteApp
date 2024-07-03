package com.felix.cleannoteapp.core.di

import android.content.Context
import androidx.room.Room
import com.felix.cleannoteapp.core.data.NoteDao
import com.felix.cleannoteapp.core.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context : Context) : NoteDatabase {
        return Room
            .databaseBuilder(context, NoteDatabase::class.java, "notes.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(database: NoteDatabase) : NoteDao = database.noteDao()

}