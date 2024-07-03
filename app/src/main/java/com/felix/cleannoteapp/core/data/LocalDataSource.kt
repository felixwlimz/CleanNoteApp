package com.felix.cleannoteapp.core.data

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val noteDao: NoteDao) {

    fun getAllNotes() : Flowable<List<NoteEntity>>{
        return noteDao.getAllNotes()
    }

    fun getNotesById(id : Int) : Flowable<NoteEntity> {
        return noteDao.getNoteById(id)
    }

    fun insertNote(noteEntity: NoteEntity) : Single<Int> {
        return noteDao.insertNote(noteEntity)
    }

    fun updateNote(noteEntity: NoteEntity) : Single<Int> {
        return noteDao.updateNote(noteEntity)
    }

    fun deleteNote(noteEntity: NoteEntity) : Single<Int> {
        return noteDao.deleteNote(noteEntity)
    }






}