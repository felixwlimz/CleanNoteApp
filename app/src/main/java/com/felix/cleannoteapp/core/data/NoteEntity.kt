package com.felix.cleannoteapp.core.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id : Int,

    @ColumnInfo("title")
    val title : String,

    @ColumnInfo("description")
    val description : String,

    @ColumnInfo("createdAt")
    val createdAt : Long ,

    @ColumnInfo("updatedAt")
    val updatedAt : Long
)
