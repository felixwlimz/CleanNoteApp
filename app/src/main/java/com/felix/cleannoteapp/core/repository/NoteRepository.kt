package com.felix.cleannoteapp.core.repository

import com.felix.cleannoteapp.core.data.LocalDataSource
import com.felix.cleannoteapp.core.data.NoteEntity
import com.felix.cleannoteapp.core.domain.model.Note
import com.felix.cleannoteapp.core.utils.Mapper
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NoteRepository @Inject constructor(private val localDataSource: LocalDataSource) : INoteRepository {

    private val mapper : Mapper<NoteEntity, Note> = object : Mapper<NoteEntity, Note> {
        override fun mapToDomain(data: NoteEntity): Note {
            return Note(
                id = data.id,
                title = data.title,
                description = data.description,
                createdAt = data.createdAt,
                updatedAt = data.updatedAt
            )
        }

        override fun mapToEntity(data: Note): NoteEntity {
            return NoteEntity(
                id = data.id,
                title = data.title,
                description = data.description,
                createdAt = data.createdAt,
                updatedAt = data.updatedAt
            )
        }

    }


    override fun getAllNotes(): Flowable<List<Note>> {
        return localDataSource.getAllNotes().map { entities ->
            entities.map {
                mapper.mapToDomain(it)
            }
        }
    }

    override fun getNoteById(id: Int): Flowable<Note> {
        return localDataSource.getNotesById(id).map {
            mapper.mapToDomain(it)
        }
    }

    override fun insertNote(note: Note): Single<Int> {
        return localDataSource.insertNote(mapper.mapToEntity(note))
    }

    override fun updateNote(note: Note): Single<Int> {
        return localDataSource.updateNote(mapper.mapToEntity(note))
    }

    override fun deleteNote(note: Note): Single<Int> {
        return localDataSource.deleteNote(mapper.mapToEntity(note))
    }



}

