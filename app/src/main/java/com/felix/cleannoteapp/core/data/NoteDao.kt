package com.felix.cleannoteapp.core.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

@Dao
interface NoteDao {


    @Query("SELECT * FROM notes")
    fun getAllNotes() : Flowable<List<NoteEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity) : Single<Long>


    @Update
    fun updateNote(noteEntity: NoteEntity) : Single<Int>


    @Delete
    fun deleteNote(noteEntity: NoteEntity) : Single<Int>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id : Int) : Flowable<NoteEntity>

}