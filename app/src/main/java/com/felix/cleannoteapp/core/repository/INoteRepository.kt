package com.felix.cleannoteapp.core.repository

import com.felix.cleannoteapp.core.domain.model.Note
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface INoteRepository {

    fun getAllNotes() : Flowable<List<Note>>

    fun getNoteById(id : Int) : Flowable<Note>

    fun insertNote(note : Note) : Single<Int>

    fun updateNote(note : Note) : Single<Int>

    fun deleteNote(note : Note) : Single<Int>



}