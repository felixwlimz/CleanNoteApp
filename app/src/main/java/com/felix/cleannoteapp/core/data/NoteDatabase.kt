package com.felix.cleannoteapp.core.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [], exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao
}